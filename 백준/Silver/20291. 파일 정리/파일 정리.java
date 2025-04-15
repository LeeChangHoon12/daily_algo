import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception {
		
		HashMap<String, Integer> files = new HashMap<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), ".");
			String text = st.nextToken();
			String target = st.nextToken();
			
			if(!files.containsKey(target)) {
				files.put(target, 1);
			}else {
				files.put(target, files.get(target)+1);
				
			}
		}
		
		Set<String> keys = files.keySet();
		
		ArrayList<String> newKeys = new ArrayList<>();
		
		for(String key : keys) {
			newKeys.add(key);
		}
		
		Collections.sort(newKeys);
		
		for(String key : newKeys) {
			System.out.println(key + " " + files.get(key));
		}
		
	}
}

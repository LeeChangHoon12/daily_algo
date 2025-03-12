import java.util.*;
import java.io.*;

public class Main {
	
	static int[] arr;
	static String str;
	static boolean[] visited;
	static int cnt = 0;
	static int target;
	static boolean flag;
	static String line;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while( (line = br.readLine()) != null && !line.isEmpty()) {
			
			
			StringTokenizer st = new StringTokenizer(line);
	
			
			str = st.nextToken();
			target = Integer.parseInt(st.nextToken());
			
			arr = new int[str.length()];
			visited = new boolean[str.length()]; 
			cnt = 0;
			flag = false;
			
			dfs(0);
			if(!flag) {
				System.out.print(str + " " + target + " = ");
				System.out.println("No permutation");
			}
			
		}
		
		
	}
	
	public static void dfs(int depth) {
		if(depth == str.length()) {
			if(++cnt == target) {
				flag = true;
				System.out.print(str + " " + target + " = ");
				for(int index : arr) {
					System.out.print(str.charAt(index));
				}
				System.out.println();
			}
			
			return;
		}
		
		for(int i=0; i<str.length();i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				dfs(depth+1);
				visited[i] = false;
			}
			
		}
	}
}

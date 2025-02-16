import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arrN;
	static int[] arrM;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
	
		arrN = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());

		Arrays.sort(arrN);
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			System.out.println(search(Integer.parseInt(st.nextToken())));
		}
		
	}
	
	public static int search(int target) {
		int st = 0;
		int en = N-1;
		
		
		while(st<=en) {
			int mid = (st+en)/2;
			if(arrN[mid] == target) {
				return 1;
			}else if(arrN[mid] < target) {
				st = mid+1;
			}else {
				en = mid-1;
			}			
		}
		return 0;
		
	}
}

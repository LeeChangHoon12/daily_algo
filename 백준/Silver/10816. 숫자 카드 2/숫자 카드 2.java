import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int N;
	static int M;
	static int[] cntPlus = new int[10000001];
	static int[] cntMinus = new int[10000001];;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++) {
			int target = Integer.parseInt(st.nextToken());
			arr[i] = target;
		}

		Arrays.sort(arr);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int target = Integer.parseInt(st.nextToken());
			
			sb.append(upperbound(target) - lowerbound(target) + " ");
		}
		
		System.out.println(sb);
		
	}
	
	public static int lowerbound(int target) {
	
		int st = 0;
		int en = N;
		
		while(st < en) {
			int mid =(st+en)/2;
			if(arr[mid] >= target) {
				en = mid;
			}else {
				st = mid+1;
			}
		}
		return st;
	}
	
	public static int upperbound(int target) {
		
		int st = 0;
		int en = N;
		
		while(st < en) {
			int mid = (st+en)/2;
			if(arr[mid] > target) {
				en = mid;
			}else{				
				st = mid+1;
			}
		}
		
		return st;
	}
	

}

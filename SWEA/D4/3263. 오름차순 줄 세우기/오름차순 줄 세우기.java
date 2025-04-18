
import java.io.*;
import java.util.*;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static List<Integer> result;
	static int N;
	static int[] arr;
	static int[] pos;
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			input();
			int result =0;
			int cnt = 1;
			
			for(int i=0; i<N; i++) {
				pos[arr[i]-1]=i+1;
			}
			
			//System.out.println(Arrays.toString(pos));
			
			for(int i=1; i<N; i++) {
				if(pos[i-1] < pos[i]) {
					cnt++;
				}else {
					result = Math.max(result,cnt);
					cnt = 1;
				}
			}
			result = Math.max(result,cnt);
			System.out.println("#" + t + " " + (N - result));
		}
	}
	
	public static void input() throws Exception {
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		pos = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
	
		
	}

	
}

import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][] dp;
	static int N,K;
	static int[] values;
	static int[] weights;
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			input();
			
			for(int i=1; i<=N; i++) {
				for(int w=1; w<=K; w++) {
					if(weights[i] <= w) {
						dp[i][w] = Math.max(dp[i-1][w],  dp[i-1][w-weights[i]] + values[i]);
					}else {
						dp[i][w] = dp[i-1][w];
					}
				}
			}
			
			System.out.println("#"+t + " " + dp[N][K]);
		}
		
	}
	
	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		values = new int[N+1];
		weights = new int[N+1];
		
		dp = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}
		
	}
}

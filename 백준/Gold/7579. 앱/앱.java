import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		int[] memory = new int[N+1];
		int[] cost = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i <=N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int sumCost = 0;
		for(int i=1;i <=N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sumCost += cost[i];
		}
		
		
		int[][] dp = new int[N+1][sumCost+1];
		
		for(int i=1; i<=N; i++) {
			for(int k=0; k<=sumCost; k++) {
				if(k >= cost[i]) {
					dp[i][k] = Math.max(dp[i-1][k], dp[i-1][k-cost[i]]+memory[i]);
				}else {
					dp[i][k] = dp[i-1][k];
				}
			}
		}
		
		for(int i=0;i<=sumCost;i++) {
			if(dp[N][i] >= K) {
				System.out.println(i);
				break;
			}
		}
		
		
	}
}

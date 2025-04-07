import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] weights = new int[N + 1];
		int[] values = new int[N + 1];

		int[][] dp = new int[N + 1][K + 1];

		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= K; w++) {
				
				//배낭의 무게가 더 큰 경우
				if(weights[i] <= w ) {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]] + values[i]);
				}else {
					dp[i][w] = dp[i-1][w];
				}				
			}
		}
		
		System.out.println(dp[N][K]);
		
	}
}

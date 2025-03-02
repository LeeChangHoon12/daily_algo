import java.util.*;
import java.io.*;

/** 
 * 1~N까지의 집
 * 빨강, 초록, 파랑을 칠하는 비용을 최소로 해보자
 * 
 * 비용이 들어갈 배열 : 
 * memo[N번째집][색깔]
 *
 *	점화식은 색깔별로 만들어야함.
 *	빨강으로 시작한 경우에 해당되는 점화식
 *	초록으로 시작한 경우에 해당되는 점화식
 *	파랑으로 시작한 경우에 해당되는 점화식
 *
 *  지금까지 집들 칠하고 현재 집을 빨간색으로 칠하는 비용 = 최소비용(이전에 집을 초록으로 칠한거랑, 이전에 집을 파란이랑 칠한거 중에서) + 지금 빨간색으로 칠하는 비용 
 *	dp[i][0] = Min(dp[i-1][1], dp[i-1][2]) + a[i][0]
 *
 *	위 식을 색깔별로 만들어주면,
 *	마지막 dp[N][0], dp[N][1], dp[N][2] 마지막집을 각 색으로 칠했을 떄의 최소값이 나오게됨
 * 
 * */
public class Main {
	static int[][] house;
	static int[][] memo;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//집의 각 색깔별 비용
		house = new int[N+1][3];
		//최소비용 배열
		memo = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//처음집을 각 색깔로 칠하고 시작
		memo[1][0] = house[1][0];
		memo[1][1] = house[1][1];
		memo[1][2] = house[1][2];
		
		//2번째 집부터 N번째집까지 최소비용 업데이트 (bottom up)
		for(int i=2; i<=N;i++) {
			memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) + house[i][0];
			memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) + house[i][1];
			memo[i][2] = Math.min(memo[i-1][1], memo[i-1][0]) + house[i][2];
		}
		
		//마지막 칠해진 색깔들에서 최소값 구하기
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			min = Math.min(min, memo[N][i]);
		}
				
		System.out.println(min);
	}
}


import java.io.*;
import java.util.*;

/**
 * N * N 지역에 디저트 카페 각 칸에 숫자 = 디저트 종류 ( 디저트 이름이라고 생각해야할 듯) 대각선 방향으로 움직일 수 있음
 * 
 * - 길을 벗어나면 안됨 - 똑같은 메뉴 안먹음 - 카페 하나, 왔던길 돌아오기 x => 4개 이상 방문하기? - 카페를 제일 많이 방문한
 * 수 출력 - 디저트를 먹을 수 없으면 -1 ### 사각형 모양을 그리면서 출발한 카페로 돌아와야함####
 * 
 * 
 * 
 */
public class Solution {
	static int[][] map;

	static int[] dirR = { 1, 1, -1, -1 };
	static int[] dirC = { 1, -1, -1, 1 };

	static boolean[][] visited;
	static boolean[] ate;
	static int N, max;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			input();

			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {

					visited = new boolean[N][N];
					ate = new boolean[101];

					visited[i][j] = true;
					ate[map[i][j]] = true;

					dfs(i, j, i, j, 0, 1); // dfs 돌아갈 때 현재 행 좌표 시작 열, dfs 돌아갈 때 현재 행 좌표 ,최초 행 좌표, 최초 열 좌표
				}
			}

			if (max == 0) {
				max = -1;
			}

			System.out.println("#" + tc + " " + max);

		}

	}

	public static void dfs(int r, int c, int startR, int startC, int preDir, int cnt) {

		for (int d = preDir; d < 4; d++) {
			int nextR = r + dirR[d];
			int nextC = c + dirC[d];

			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N)
				continue;

			if (cnt >= 4 && nextR == startR && nextC == startC) {
				max = Math.max(cnt, max);
			}

			if (visited[nextR][nextC])
				continue;
			if (ate[map[nextR][nextC]])
				continue;

			visited[nextR][nextC] = true;
			ate[map[nextR][nextC]] = true;
			dfs(nextR, nextC, startR, startC, d, cnt + 1);
			visited[nextR][nextC] = false;
			ate[map[nextR][nextC]] = false;

		}

	}

	public static void input() throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		max = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}

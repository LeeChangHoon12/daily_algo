import java.io.*;
import java.util.*;

public class Solution {

	static int[] dirR = { 0, 0, -1, 1, 1, 1, -1, -1 };
	static int[] dirC = { -1, 1, 0, 0, -1, 1, 1, -1 };

	static char[][] map;
	static boolean[][] visited;
	static int N;

	static int cnt;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input();
			cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] != '*') {

						if (!nearByMine(i, j)) {
							bfs(i, j);
							cnt++;
						}
						
					}
				}
			}
			
	

			for(int i = 0; i< N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j] != '*') {
						cnt++;
					}
				}
			}

			System.out.println("#" + tc + " " + cnt);
		}

	}

	public static void input() throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
	}

	// 0,0부터 클릭 bfs로 넓혀감
	// 1. 현재 위치가 지뢰면 클릭X
	// 2. 현재 위치에서 주위에 지뢰가 없으면 bfs진행해서 열어주기
	// 3. 전부 끝나고 남아있는 칸 열어주기
	public static void bfs(int r, int c) {
		Node start = new Node(r, c);
		Queue<Node> queue = new ArrayDeque<>();

		visited[r][c] = true;
		//map[r][c] = 'c';
		queue.offer(start);

		while (!queue.isEmpty()) {
			Node current = queue.poll();

			for (int d = 0; d < 8; d++) {
				int nextR = current.r + dirR[d];
				int nextC = current.c + dirC[d];

				if (isOut(nextR, nextC) || visited[nextR][nextC])
					continue;

				visited[nextR][nextC] = true;
				//map[nextR][nextC] = 'c';
				if (!nearByMine(nextR, nextC)) {
					queue.offer(new Node(nextR, nextC));
				}
				
			}

		}

	}

	public static boolean isOut(int nextR, int nextC) {
		return nextR < 0 || nextR >= N || nextC < 0 || nextC >= N;
	}

	public static boolean nearByMine(int r, int c) {

		for (int i = 0; i < 8; i++) {
			int nextR = r + dirR[i];
			int nextC = c + dirC[i];

			if (isOut(nextR, nextC)) {
				continue;
			}

			if (map[nextR][nextC] == '*') {
				return true;
			}
		}

		return false;
	}

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}

import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static Cell[][] map;
	static boolean[][] visited;
	static int N, M, K;
	static int OFFSET; // 격자 오프셋 (보통 K)

	static PriorityQueue<Cell> nowTime;
	static PriorityQueue<Cell> nextTime;

	static int[] dirR = { 0, 0, -1, 1 };
	static int[] dirC = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			input();

			int time = 0;
			while (time < K) {
				time++;

				while (!nextTime.isEmpty()) {
					nowTime.add(nextTime.poll());
				}

				while (!nowTime.isEmpty()) {
					Cell now = nowTime.poll();

					if (now.life == now.time) {
						spread(now);
					}

					now.time++;

					if (now.time == now.life * 2)
						continue;

					nextTime.add(new Cell(now.r, now.c, now.life, now.time));

				}
			}

			System.out.println("#" + t + " " + nextTime.size());

		}
	}

	public static boolean isOut(int r, int c) {
		return r < 0 || r >= visited.length || c < 0 || c >= visited[0].length;
	}

	public static void spread(Cell now) {
		for (int d = 0; d < 4; d++) {
			int nextR = now.r + dirR[d];
			int nextC = now.c + dirC[d];

			if (isOut(nextR, nextC))
				continue;
			if (visited[nextR][nextC])
				continue;

			visited[nextR][nextC] = true;
			nextTime.add(new Cell(nextR, nextC, now.life, 0));
		}
	}

	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 2 * K][M + 2 * K];
		nowTime = new PriorityQueue<>();
		nextTime = new PriorityQueue<>();

		for (int r = K; r < K + N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = K; c < K + M; c++) {
				int life = Integer.parseInt(st.nextToken());
				if (life != 0) {
					visited[r][c] = true;
					nextTime.add(new Cell(r, c, life, 0));
				}
			}
		}
	}

	static class Cell implements Comparable<Cell> {
		int r;
		int c;
		int life;
		int time;

		public Cell(int r, int c, int life, int time) {
			this.r = r;
			this.c = c;
			this.life = life;
			this.time = time;
		}

		@Override
		public int compareTo(Cell o) {
			return Integer.compare(o.life, this.life);
		}
	}
}

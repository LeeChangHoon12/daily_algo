import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, K;
	static Node[][] map;
	static PriorityQueue<Node> newList, oldList;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input();

			for (int time = 0; time < M; time++) {
				map = new Node[N][N];

				while (!newList.isEmpty()) {
					oldList.offer(newList.poll());
				}

				while (!oldList.isEmpty()) {
					Node cur = oldList.poll();
					int nr = cur.r + dr[cur.dir];
					int nc = cur.c + dc[cur.dir];
					int cnt = cur.cnt;
					int dir = cur.dir;

					if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
						cnt /= 2;
						if (cnt == 0)
							continue; 
						dir = (dir + 2) % 4;
					}

					if (map[nr][nc] == null) {
						map[nr][nc] = new Node(nr, nc, cnt, dir);
					} else {
						Node ex = map[nr][nc];
						int sumCnt = ex.cnt + cnt;
						int sumDir = (ex.cnt >= cnt) ? ex.dir : dir;
						map[nr][nc] = new Node(nr, nc, sumCnt, sumDir);
					}
				}

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] != null) {
							newList.offer(map[i][j]);
						}
					}
				}
			}

			int result = 0;
			while (!newList.isEmpty()) {
				result += newList.poll().cnt;
			}
			System.out.println("#" + tc + " " + result);
		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		newList = new PriorityQueue<>();
		oldList = new PriorityQueue<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			int tmpDir = Integer.parseInt(st.nextToken());

			int dir = 0;
			if (tmpDir == 1)
				dir = 0;
			else if (tmpDir == 2)
				dir = 2;
			else if (tmpDir == 3)
				dir = 1;
			else if (tmpDir == 4)
				dir = 3;

			newList.offer(new Node(r, c, cnt, dir));
		}
	}

	static class Node implements Comparable<Node> {
		int r, c, cnt, dir;

		Node(int r, int c, int cnt, int dir) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.cnt, this.cnt);
		}
	}
}

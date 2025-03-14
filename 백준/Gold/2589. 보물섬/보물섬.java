import java.io.*;
import java.util.*;


public class Main{
	
	static int[] dirR = {0,0,-1,1};
	static int[] dirC = {1,-1,0,0};
	
	static int N,M;
	static char[][] map;
	static int[][] result ;
	static boolean[][] visited;
	static int max = 0;
	static Queue<Pos> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int r=0; r<N; r++) {
			String line = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = line.charAt(c);
			}
		}
		
		
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 'L') {
					
					
					visited = new boolean[N][M];
					result = new int[N][M];
	
					bfs(r,c,0);
		
				}
			}
		}
		
		
		
		System.out.println(max);
	}
	
	public static void bfs(int nowR, int nowC, int cnt) {
		
		
		visited[nowR][nowC] = true;
		q.offer(new Pos(nowR,nowC,cnt));
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			for(int i=0; i<4; i++) {
				int nextR = now.r + dirR[i];
				int nextC = now.c + dirC[i];
				
				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)
					continue;
				if(map[nextR][nextC] == 'W') continue;
				if(visited[nextR][nextC]) continue;
				
				visited[nextR][nextC] = true;
				result[nextR][nextC] = now.cnt + 1;
				max = Math.max(now.cnt+1, max);
				q.offer(new Pos(nextR,nextC,now.cnt + 1));

			}
						
		}
		
	}
	
	static class Pos{
		int r;
		int c;
		int cnt;
		public Pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}

import java.util.*;
import java.io.*;

/**
 * 알러지 반응이 나타나지 않은 지역 몇개
 * 
 * 농도에 따라 안전 점수 이하의 지점에서 알레르기 반응
 * 
 * 꽃가루 농도 4 안전점수가 4보다 같거나 낮으면 알러지 반응
 * 
 */
public class Main {

	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	
	static Queue<Pos> q;
	
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int score;
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// --------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c]  = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int score = 0; score <= 100; score++) {
			visited = new boolean[N][N];
			//안전지대 개수
			int tmp = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(bfs(r,c,score)) {
						tmp++;
					}
				}
			}
			max = Math.max(tmp, max);
		}
		
		System.out.println(max);
	

	}
	
	public static  boolean bfs(int r, int c,int score) { //r,c , 농도
		
		//시작지점이 안전해야 bfs시작 
		if(visited[r][c] || map[r][c] <= score) return false;
		
		q = new ArrayDeque<>();
		visited[r][c] = true;
		q.offer(new Pos(r,c));
		while(!q.isEmpty()) {
			
			Pos now = q.poll();
			
			int curR = now.r;
			int curC = now.c;
			
			for(int d=0; d<4; d++) {
				int nextR = curR + dr[d];
				int nextC = curC + dc[d];
				
				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || visited[nextR][nextC] || map[nextR][nextC] <= score) {
					continue;
				}
				
				visited[nextR][nextC] = true;
				q.offer(new Pos(nextR, nextC));
				
			}
		}
		
		return true;
		
	}
	
	static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}

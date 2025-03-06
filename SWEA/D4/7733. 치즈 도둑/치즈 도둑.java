
import java.io.*;
import java.util.*;

/** 
 * 정사각형 N*N 치즈
 * 맛있는 정도는 1~100  각 셀에 들어감
 *  
 * 
 * */

public class Solution {
	
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int cnt;
	static int max;
	
	static int[] dirR = {0,0,-1,1};
	static int[] dirC = {1,-1,0,0};
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			
			input();
			
			for(int day=0; day<=100; day++) {
				cnt = 0;
				visited = new boolean[N][N];
				for(int r = 0; r < N; r++ ) {
					for(int c = 0; c < N; c++) {
						if(map[r][c] > day && !visited[r][c]) {
							dfs(r,c,day);
							cnt++;
						}
						
					}
				}
				max = Math.max(max, cnt);
			}
			System.out.println("#" + tc + " " + max);
		}
		
	}
	
	public static void input() throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static void dfs(int r, int c, int day) {
		Queue<Node> queue = new ArrayDeque<>();
		
		queue.add(new Node(r,c));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nextR = current.r + dirR[d];
				int nextC = current.c + dirC[d];
				
				if(isOut(nextR,nextC) || visited[nextR][nextC] || map[nextR][nextC] <= day) continue;
				
				visited[nextR][nextC] = true;
				queue.add(new Node(nextR,nextC));
			}
			
		}
	}
	
	public static boolean isOut(int nextR, int nextC) {
		return nextR < 0 || nextR >= N || nextC < 0 || nextC >= N;
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

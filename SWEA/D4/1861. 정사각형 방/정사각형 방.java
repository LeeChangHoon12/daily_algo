import java.io.*;
import java.util.*;

public class Solution {

	static int[] dirR = { 0, 0, 1, -1 };
	static int[] dirC = { 1, -1, 0, 0 };

	static int T;
	static int N;
	static int[][] map;
	static int[][] result;



	static int cnt;
	static int max;
	static int finalNum;
	
	static ArrayList<Integer> arr;



	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input();
			cnt = 1;
			max = 0;
			finalNum = Integer.MAX_VALUE;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					dfs(r, c,map[r][c], 1);
					result[r][c] = cnt;
				}
			}
			
			for(int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(result[r][c] == max && map[r][c] < finalNum) {
						finalNum = map[r][c];
					}
				}
			}

			
			System.out.println("#" + tc + " " + finalNum + " " + max);
		}
	}

	public static void input() throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		result = new int[N][N];


		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static boolean isOut(int nextR, int nextC) {
		return nextR < 0 || nextR >= N || nextC < 0 || nextC >= N;
	}

	public static void dfs(int startR, int startC,int startNum, int depth) {
		
	

		boolean isMove = false;
		for (int i = 0; i < 4; i++) {
			int nextR = startR + dirR[i];
			int nextC = startC + dirC[i];


			if (isOut(nextR, nextC)) {
				continue;
			}
			
			if((map[startR][startC]+1) != map[nextR][nextC]) {
				continue;
			}
			
			isMove = true;
			
			dfs(nextR, nextC, startNum,depth+1);
		
		}

		if(!isMove) {
			cnt = depth;
			max = Math.max(cnt, max);

			return;
		}
		

	}

}

import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[] dirR = {1,-1, 0, 0};
	static int[] dirC = {0,0,-1,1};
	
	static int nowR;
	static int nowC;
	
	static char[][] map;
	static int H, W, N;
	static String command;
	
	public static void main(String[] args) throws Exception{
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			input();
			
			for(int i = 0; i < N; i++) {
				move(command.charAt(i));
			}
			
			System.out.print("#"+tc + " ");
			for(int r=0; r<H; r++) {
				for(int c=0; c<W; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
			
		}
	}
	
	public static void input() throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		
		for(int i=0; i<H; i++) {
			String tmp = br.readLine();
			for(int j=0; j<W; j++) {
				map[i][j] = tmp.charAt(j);
				
				if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
					nowR = i;
					nowC = j;
				}
			}
		}
		
		N = Integer.parseInt(br.readLine());
		command = br.readLine();
	}
	
	public static void move(char command) {
		
		if(command == 'U') {
			map[nowR][nowC] = '^';
			int nextR = nowR-1;
			int nextC = nowC;
			
			if(isOut(nextR,nextC) || map[nextR][nextC] == '-') return;
			
			if(map[nextR][nextC] == '.') {
				map[nowR][nowC] = '.';
				map[nextR][nextC] = '^';
				
				nowR = nextR;
				nowC = nextC;
			}
			
		}else if(command == 'D') {
			map[nowR][nowC] = 'v';
			int nextR = nowR+1;
			int nextC = nowC;
			
			if(isOut(nextR,nextC) || map[nextR][nextC] == '-') return;
			
			if(map[nextR][nextC] == '.') {
				map[nowR][nowC] = '.';
				map[nextR][nextC] = 'v';
				nowR = nextR;
				nowC = nextC;
			}
		
		}else if(command =='L') {
			map[nowR][nowC] = '<';
			int nextR = nowR;
			int nextC = nowC - 1;
			
			if(isOut(nextR,nextC)  || map[nextR][nextC] == '-') return;
			
			if(map[nextR][nextC] == '.') {
				map[nowR][nowC] = '.';
				map[nextR][nextC] = '<';
				nowR = nextR;
				nowC = nextC;
			}
			
		}else if(command =='R') {
			map[nowR][nowC] = '>';
			int nextR = nowR;
			int nextC = nowC + 1;
			
			if(isOut(nextR,nextC)  || map[nextR][nextC] == '-') return;
			
			if(map[nextR][nextC] == '.') {
				map[nowR][nowC] = '.';
				map[nextR][nextC] = '>';
				nowR = nextR;
				nowC = nextC;
			}
			
		}else if(command =='S') {
			if(map[nowR][nowC] == '>') {
				int tmpR = nowR;
				int tmpC = nowC + 1;
				
				while(!isOut(tmpR, tmpC) ) {
					if(map[tmpR][tmpC] == '*') {
						map[tmpR][tmpC] = '.';
						
						break;
					}
					if(map[tmpR][tmpC] == '#') {
						break;
					}
					tmpC++;
				}
				
			}else if(map[nowR][nowC] == '<') {
				int tmpR = nowR;
				int tmpC = nowC - 1;
				
				while(!isOut(tmpR, tmpC)) {
					if(map[tmpR][tmpC] == '*') {
						map[tmpR][tmpC] = '.';
						
						break;
					}
					if(map[tmpR][tmpC] == '#') {
						break;
					}
					tmpC--;
				}
				
			}else if(map[nowR][nowC] == '^') {
				int tmpR = nowR -1;
				int tmpC = nowC;
				
				while(!isOut(tmpR, tmpC)) {
					if(map[tmpR][tmpC] == '*') {
						map[tmpR][tmpC] = '.';
						
						break;
					}
					if(map[tmpR][tmpC] == '#') {
						break;
					}
					tmpR--;
				}
				
			}else if(map[nowR][nowC] == 'v') {
				int tmpR = nowR + 1;
				int tmpC = nowC;
				
				while(!isOut(tmpR, tmpC)) {
					if(map[tmpR][tmpC] == '*') {
						map[tmpR][tmpC] = '.';
						break;
					}
					if(map[tmpR][tmpC] == '#') {
						break;
					}
					tmpR++;
				}
			}
		}
	}
	
	public static boolean isOut(int nextR, int nextC) {
		return nextR < 0 || nextR >= H || nextC < 0 || nextC >= W; 
	}
}


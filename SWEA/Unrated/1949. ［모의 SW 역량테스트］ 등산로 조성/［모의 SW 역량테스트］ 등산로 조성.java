import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution  {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][] map;
	static int N, K, start;
	static int result;
	static boolean[][] visited;
	
	static int[] dirR = {0,0,-1,1};
	static int[] dirC = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			input();
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] == start) {
						int length = 1;
						boolean used  = false;
						visited  = new boolean[N][N];
						visited[r][c] = true;
						dfs(r,c,length ,used,map[r][c]);
					}
				}
			}
			
			System.out.println("#" + t + " " + (result));
			
		}
	}
	
	public static void input() throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		result = 1;
		start = 0;
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				start = Math.max(start, map[r][c]);
			}
		}
		
	}
	
	public static void dfs(int r, int c, int length, boolean used,int nowHeight) {
		
		
		for(int i=0; i<4; i++) {
			int nextR = r + dirR[i];
			int nextC = c + dirC[i];
			
			if(isOut(nextR,nextC)) continue;
			if(visited[nextR][nextC]) continue;
			
			//다음칸이 지금보다 작으면 이동
			if(map[nextR][nextC] < nowHeight) {
				visited[nextR][nextC] = true;
				result = Math.max(length+1, result);
				dfs(nextR,nextC,length+1,used,map[nextR][nextC]);
				visited[nextR][nextC] = false;
			//아직 한번도 안깎았고, 깍으면 갈 수 있다면 
			}else if(!used && map[nextR][nextC]-K < map[r][c]){
				visited[nextR][nextC] = true; //방문처리
				used = true; //사용해줌 
				result = Math.max(length+1, result); //최대값 갱신
				dfs(nextR, nextC, length+1, used, nowHeight-1);
				visited[nextR][nextC] = false;
				used= false;
			}
			
		}
	}
	
	public static boolean isOut(int nextR, int nextC) {
		return nextR < 0 || nextR >= N  ||nextC < 0 || nextC >= N;
	}
}

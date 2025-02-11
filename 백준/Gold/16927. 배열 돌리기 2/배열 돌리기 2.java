
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	//static boolean[][] visited;
	static int N;
	static int M;
	static int R;

	static int[] dirR = { 1, 0, -1, 0 };
	static int[] dirC = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		

		//돌려야할 레벨 수
		int minLevel = Math.min(N, M)/2;

		//돌리기
		for (int level = 0; level < minLevel; level++) {
			ratation(level);
		}
		
		//출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void ratation(int level) {

		int rotate = R % (((N-2*level) + (M-2*level))*2 -4);

		for(int r=0; r<rotate; r++) {


			//visited = new boolean[N][M];
			
			int cnt = 0;
			
			int row = level
					;
			int col = level;
			
			int tmp = map[row][col];
			
			//한칸씩 돌리기 
			while (cnt < 4) {
				//if (visited[row][col]) {
					//break;
				//}
				//visited[row][col] = true;

				int nextR = row + dirR[cnt % 4];
				int nextC = col + dirC[cnt % 4];

				if (nextR < level || nextR >= N - level || nextC < level || nextC >= M - level) {
					cnt++;
					nextR = row + dirR[cnt % 4];
					nextC = col + dirC[cnt % 4];
				}
				int now = tmp;
				tmp = map[nextR][nextC];
				map[nextR][nextC] = now;
				
				row = nextR;
				col = nextC;
				
			}
		}

		
	}
	
}
	 


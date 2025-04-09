import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N+1][N+1];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			map[from][to] = -1;
			map[to][from] = 1;

		}


		for (int k = 1; k <= N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					
					if(map[i][k] == 1 && map[k][j] == 1) {
						map[i][j]= 1;
					}else if(map[i][k] == -1 && map[k][j] == -1) {
						map[i][j] = -1;
					}
					
				}
			}
		}
		
	
		
		int t = Integer.parseInt(br.readLine());
		
		//System.out.println(t);
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			System.out.println(map[from][to]);
		}

	}
}

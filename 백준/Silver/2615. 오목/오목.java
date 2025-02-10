
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	static int[][] map = new int[19][19];
	
	static int[] dirX = {-1,1,0,0,1,-1,-1,1}; 
	static int[] dirY = {0,0,-1,1,1,-1,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<19;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		for(int j=0;j<19;j++) {
			for(int i=0; i<19;i++) {
				if(map[i][j] != 0) {
					if(check(i,j)) {
						System.out.println(map[i][j]);
						System.out.println((i+1) + " " + (j+1));
						return;
					}									
				}
			}
		}
		
		System.out.println(0);
		
		
	}
	
	public static boolean check(int x,int y) {
		
		int startX = x;
		int startY = y;

		int cnt = 0;
		int arr[] = new int[8];

		for(int i=0; i<8; i++) {

			cnt = 0;
			x = startX;
			y = startY;
			
			while(true) {
				int nextX = x + dirX[i];
				int nextY = y + dirY[i];
				
				if(nextX < 0 || nextX >= 19 || nextY < 0 || nextY >= 19 || map[nextX][nextY] != map[x][y] || map[nextX][nextY] == 0) {
					break;
				}		
				
				x = nextX;
				y = nextY;
				
				cnt++;
			}
			
			arr[i] = cnt;
		}
		
		for(int i=0; i<8; i+=2) {
			if((arr[i]==0 && arr[i+1]==4)|| (arr[i+1]==0 && arr[i]==4)) {
				return true;
			}
		}

		return false;
	}
}

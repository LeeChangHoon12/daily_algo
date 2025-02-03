
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] widthArr;
	static int[] heightArr;
	static boolean[][] map = new boolean[100][100]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		widthArr = new int[N];
		heightArr = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			widthArr[i] = Integer.parseInt(st.nextToken());
			heightArr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			int firstX = widthArr[i];
			int lastX = firstX+10;
			
			int firstY = heightArr[i];
			int lastY = firstY + 10;
			
			
			for(int x=firstX; x<lastX; x++) {
				for(int y=firstY; y<lastY; y++	) {
					if(map[x][y]) {
						continue;
					}else {
						map[x][y] = true;
						cnt++;
					}
				}
			}
		}
				
				
	
		
		System.out.println(cnt);
		
		
	}
}

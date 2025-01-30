import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main  {
    static int[][] map;
    static int x1;
    static int y1;
    static int x2;
    static int y2;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[100][100];
        for(int i=0; i<4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for(int x=x1 ; x<x2; x++){
                for(int y=y1; y<y2; y++){
                    map[x][y] = 1;
                }
            }

        }
        int result = 0;
        for(int i=0; i<100;i++){
            for(int j=0; j<100; j++){
                if(map[i][j] == 1){
                    result++;
                }
            }
        }
        System.out.println(result);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map = new int[1001][1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());

            for(int row=r; row<(r+height); row++){
                for(int col=c; col<(c+width); col++){
                    map[row][col] = i;
                }
            }
        }


        for(int i=1; i<=N; i++){
            int count = 0;
            for(int r=0; r<1001; r++){
                for(int c=0; c<1001; c++){
                    if(map[r][c] == i){
                        count++;
                    }
                }
            }
            System.out.println(count);

        }



    }
}

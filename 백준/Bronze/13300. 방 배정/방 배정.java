import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int room[][] = new int[2][7];
        int roomCount = 0;

        for(int i=0;i<2;i++){
            for(int j=0; j<7; j++){
                room[i][j] = K;
            }
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            if(room[s][g] == K){
                room[s][g] = 0;
                roomCount++;
            }
            room[s][g]++;
        }

        System.out.println(roomCount);

    }
}

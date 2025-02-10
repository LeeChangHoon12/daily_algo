import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

    static int T;

    static int M;
    static int N;
    static int k;
    static int D;

    static int A;
    static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            System.out.println(games(N,M,k,D));

        }
    }

    public static int games(int N,int M,int k,int D){

        int result = 0;
        B = 1;

        while(true){
            A= k * B;

            int count1 = M * (M-1)/2 * N * A;
            int count2 = N * (N-1)/2 * M * M * B;

            if( count1 + count2 <= D) {
                result = Math.max(count1 + count2,result);
                B++;
            }else{

                if(B == 1){
                    return -1;
                }
                return result;
            }
        }
    }
}

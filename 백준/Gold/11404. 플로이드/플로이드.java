import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] result;
    static int[][] graph2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        result = new int[N+1][N+1];


        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i == j){
                    result[i][j] = 0;
                }else{
                    result[i][j] = Integer.MAX_VALUE;
                }


            }
        }


        int M = Integer.parseInt(br.readLine());
        for( int i =0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            //result[start][end] = weight;
            result[start][end] = Math.min(result[start][end], weight);
        }



        for(int middle=1; middle<=N; middle++){
            for(int start = 1; start <= N; start++){
                for(int end =1; end<=N; end++){
                    if(result[start][middle] == Integer.MAX_VALUE || result[middle][end] == Integer.MAX_VALUE) continue;
                    result[start][end] = Math.min(result[start][end], result[start][middle] + result[middle][end]);
                }
            }
        }

        for(int i=1; i<= N; i++){
            for(int j=1; j<= N; j++){
                if(result[i][j] == Integer.MAX_VALUE){
                    System.out.print(0 + " ");
                }else{
                    System.out.print(result[i][j] + " ");
                }

            }
            System.out.println();
        }
    }

}

import java.io.*;
import java.util.*;

public class Solution {

    static int N, M;

    static int[][] map; // 인접 행렬

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            input();

            //플로이드 워셜
            for(int k=1; k<=N; k++){
                for(int i=1; i<=N; i++){
                    for(int j=1; j<=N; j++){
                        if(map[i][k] == Integer.MAX_VALUE || map[k][j] == Integer.MAX_VALUE) continue;
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }

            int answer = 0;
            int[] count = new int[N+1];
            // i와 관계가 있는 인원을 찾음
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] != Integer.MAX_VALUE) {
                        count[i] = count[i] + 1;
                    }
                    if (map[j][i] != Integer.MAX_VALUE) {
                        count[i] = count[i] + 1;
                    }
                }
            }
            //N-1명과 관계가 있으면 본인이 몇 번째 위치인지 알수있음
            for (int i = 1; i <= N; i++) {
                if (count[i] == N - 1) {
                    answer++;
                }
            }

            System.out.println("#" + t + " " + answer);

        }

    }

    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        for(int i=0; i<=N; i++){
            Arrays.fill(map[i],Integer.MAX_VALUE);
        }
//        for(int i=0; i<=N; i++){
//            for(int j=0; j<=N; j++){
//                if(i==j) map[i][j] = 0;
//            }
//        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map[from][to] = 1;
        }
    }

}
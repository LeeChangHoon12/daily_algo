import java.io.*;
import java.util.*;

public class Solution {

    static int[][] map;
    static int N,M;
    static int k;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            input();
            int result = 0;
            int K = 1;
            int price = 1; //운영 비용

            while(K < N*2){

                //이번 k에서 커버하는 집 개수
                int homeCntMax = 0;

                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        //이번 K에서 커버하는 최대 개수
                        homeCntMax = Math.max(homeCntMax,window(i,j,K));
                    }
                }
                //System.out.println(homeCntMax);
                if(homeCntMax * M - price >= 0){
                    result = Math.max(result, homeCntMax);
                }

                K++;
                price = K * K + (K - 1) * (K - 1);
            }

            System.out.println("#" + tc + " " + result);

        }
    }

    public static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    public static int window(int r, int c,int k){

        int result = 0;

        if(map[r][c] == 1){
            result++;
        }

        for(int i=1; i<=k-1; i++){
            int nextR = r - i;
            if(isOut(nextR,c)) continue;
            if(map[nextR][c] == 1) result++;
        }

        for(int i=1; i<=k-1; i++){
            int nextR = r + i;
            if(isOut(nextR,c)) continue;
            if(map[nextR][c] == 1) result++;
        }

        //오른쪽 가면서
        for(int i=1; i<=k-1;i++){
            int nextC = c + i;
            if(isOut(r,nextC)) continue;
            if(map[r][nextC] == 1) result++;
            //위에
            for(int j=1; j<=k-1-i;j++){
                int nextR = r - j;
                if(isOut(nextR,nextC)) continue;
                if(map[nextR][nextC] == 1) result++;
            }
            //아래
            for(int j=1; j<=k-1-i;j++){
                int nextR = r + j;
                if(isOut(nextR,nextC)) continue;
                if(map[nextR][nextC] == 1) result++;
            }
        }

        //왼쪽 가면서
        for(int i=1; i<=k-1;i++){
            int nextC = c - i;
            if(isOut(r,nextC)) continue;
            if(map[r][nextC] == 1) result++;
            //위에
            for(int j=1; j<=k-1-i;j++){
                int nextR = r - j;
                if(isOut(nextR,nextC)) continue;
                if(map[nextR][nextC] == 1) result++;
            }
            //아래
            for(int j=1; j<=k-1-i;j++){
                int nextR = r + j;
                if(isOut(nextR,nextC)) continue;
                if(map[nextR][nextC] == 1) result++;
            }
        }

        return result;
    }

    public static boolean isOut(int nextR, int nextC){
        return nextR < 0 || nextR >= N || nextC < 0 || nextC >= N;
    }
}

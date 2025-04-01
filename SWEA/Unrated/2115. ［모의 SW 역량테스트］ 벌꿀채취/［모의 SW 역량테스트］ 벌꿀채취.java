import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, C;
    static int[][] map;
    static boolean[][] visited;
    static int tmpMax = 0;

    public static void main(String[] args) throws Exception {
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
           input();
           int max = solve();
           System.out.println("#" + tc + " " +  max);
        }
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int solve() {
        int result = 0;
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) { // 열에서 M개 선택하기 떄문에 N-M까지만 봐야함

                //일단 최대값 0으로 초기화하고
                tmpMax = 0;
                dfs(i, j, 0, 0, 0);
                max1 = tmpMax; //채취1 최대값


                tmpMax = 0;
                max2 = 0;

                //그 다음 꿀 같은 행에서 보고
                for (int c = j + M; c <= N - M; c++) {
                    dfs(i, c, 0, 0, 0);
                    max2 = Math.max(max2, tmpMax); // 채취2 최대값
                }

                //다음 행부터 봐줌 (어차피 조합이니까 뒤에서 부터 보면된다!)
                for (int r = i + 1; r < N; r++) {
                    for (int c = 0; c <= N - M; c++) {
                        dfs(r, c, 0, 0, 0);
                        max2 = Math.max(max2, tmpMax); //채취2 최대값
                    }
                }

                //갱신해주기
                result = Math.max(result, max1 + max2);
            }
        }
        return result;
    }

    private static void dfs(int i, int j, int cnt, int sum, int benefit) {
        //최대 넘으면 패스
        if (sum > C)
            return;

        // M개 선택했을 때
        if (cnt == M) {
            // 갱신
            if (tmpMax < benefit)
                tmpMax = benefit;
            return;
        }

        // 선택한 경우 = 꿀채취양  , 이익 더해서 넘겨주기
        dfs(i, j + 1, cnt + 1, sum + map[i][j], benefit + map[i][j] * map[i][j]);
        // 비선택 = 그냥 넘겨주기
        dfs(i, j + 1, cnt + 1, sum, benefit);

    }
}
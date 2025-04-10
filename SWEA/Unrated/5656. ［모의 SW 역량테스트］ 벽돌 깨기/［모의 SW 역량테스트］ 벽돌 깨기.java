import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, W, H;
    static int[][] map;
    static int[][] mapOri;

    static int[] dirR = {-1, 1, 0, 0};
    static int[] dirC = {0, 0, -1, 1};
    static int result;
    static boolean[][] visited;
    static int[] colArr;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            input();

            result = Integer.MAX_VALUE;
            colArr = new int[N];  // N개의 구슬
            solve(0);

            System.out.println("#" + t + " " + result);
        }
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        mapOri = new int[H][W];
        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                mapOri[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void solve(int depth) {
        if (depth == N) {

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    map[i][j] = mapOri[i][j];
                }
            }

   
            for (int i = 0; i < N; i++) {
                visited = new boolean[H][W];

                int boomCol = colArr[i];
                int boomRow = getRow(boomCol);

                if (boomRow == H) continue;

                visited[boomRow][boomCol] = true;
                boom(boomRow, boomCol);
                change();
                drop();
            }


            int count = 0;
            for (int r = 0; r < H; r++) {
                for (int c = 0; c < W; c++) {
                    if (map[r][c] != 0) {
                        count++;
                    }
                }
            }

            result = Math.min(result, count);
            return;
        }

        for (int i = 0; i < W; i++) {
            colArr[depth] = i;
            solve(depth + 1);
        }
    }


    public static int getRow(int col) {
        for (int r = 0; r < H; r++) {
            if (map[r][col] != 0) return r;
        }
        return H;
    }

    // 폭발 처리
    public static void boom(int r, int c) {
        int power = map[r][c];
        map[r][c] = 1; // 중복 폭발 방지용

        for (int d = 0; d < 4; d++) {
            for (int i = 1; i < power; i++) {
                int nr = r + dirR[d] * i;
                int nc = c + dirC[d] * i;

                if (isOut(nr, nc)) continue;
                if (map[nr][nc] == 0 || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                boom(nr, nc);
            }
        }
    }


    public static void change() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (visited[i][j]) {
                    map[i][j] = 0;
                }
            }
        }
    }


    public static void drop() {
        for (int c = 0; c < W; c++) {
            Queue<Integer> queue = new ArrayDeque<>();
            for (int r = H - 1; r >= 0; r--) {
                if (map[r][c] != 0) {
                    queue.add(map[r][c]);
                }
            }

            for (int r = H - 1; r >= 0; r--) {
                if (!queue.isEmpty()) {
                    map[r][c] = queue.poll();
                } else {
                    map[r][c] = 0;
                }
            }
        }
    }

    public static boolean isOut(int r, int c) {
        return r < 0 || r >= H || c < 0 || c >= W;
    }
}

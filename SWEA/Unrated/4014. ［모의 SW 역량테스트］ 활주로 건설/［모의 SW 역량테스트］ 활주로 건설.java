import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N, X;
    static int[][] map;
    static int result;
    
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int t = 1; t <= T; t++) {
            input();
            result = 0;
            
            // 행 방향 (가로 활주로)
            for (int r = 0; r < N; r++) {
                int[] row = new int[N];
                for (int c = 0; c < N; c++) {
                    row[c] = map[r][c];
                }
                if (checkLine(row)) result++;
            }
            
            // 열 방향 (세로 활주로)
            for (int c = 0; c < N; c++) {
                int[] col = new int[N];
                for (int r = 0; r < N; r++) {
                    col[r] = map[r][c];
                }
                if (checkLine(col)) result++;
            }
            
            System.out.println("#" + t + " " + result);
        }
    }
    
    // 주어진 1차원 배열(행 또는 열)에 대해 활주로 건설 가능 여부 체크
    // 경사로 길이 X, 경사로를 설치한 칸은 used 배열로 기록
    public static boolean checkLine(int[] line) {
        boolean[] used = new boolean[N]; // 경사로 설치 여부 체크
        for (int i = 0; i < N - 1; i++) {
            // 높이가 동일하면 별다른 처리 없이 다음으로
            if (line[i] == line[i+1]) continue;
            
            // 인접한 칸의 높이 차이가 1을 초과하면 활주로 불가능
            if (Math.abs(line[i] - line[i+1]) > 1) return false;
            
            // 높이가 1 차이가 나는 경우
            // 1. 상승하는 경우
            if (line[i+1] - line[i] == 1) {
                // 현재 칸을 포함해 좌측 X칸이 모두 같은 높이이고, 경사로가 설치되지 않아야 함.
                for (int j = i; j >= i - X + 1; j--) {
                    if (j < 0 || line[j] != line[i] || used[j]) return false;
                    used[j] = true;
                }
            }
            
            
            // 2. 하강하는 경우 
            else if (line[i] - line[i+1] == 1) {
                // 다음 칸부터 오른쪽 X칸이 모두 같은 높이이고, 아직 경사로가 설치되지 않았어야 함.
                for (int j = i + 1; j <= i + X; j++) {
                    if (j >= N || line[j] != line[i+1] || used[j]) return false;
                    used[j] = true;
                }
            }
        }
        return true;
    }
    
    // 입력 처리 메서드
    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

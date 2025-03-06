import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] visited;
    static int[][] map;
    static int H, W;
    static int meltingCnt; // 이번 시간에 녹은 치즈 개수
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        
        map = new int[H][W];
        visited = new boolean[H][W];
        
        for (int r = 0; r < H; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < W; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 초기 외부 공기(0 또는 치즈가 아닌 영역)를 2로 채움 (BFS)
        bfs(0, 0);
        
        int time = 0;
        int lastCheese = 0;
        
        while (true) {
            meltingCnt = 0;
            // 치즈 녹이는 단계 : 공기(2)와 인접한 치즈(1)를 녹인다.
            boolean[][] meltVisited = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == 2 && !meltVisited[i][j]) {
                        melt(i, j, meltVisited);
                    }
                }
            }
            
            // 녹은 치즈가 없으면 종료
            if (meltingCnt == 0) break;
            lastCheese = meltingCnt;
            time++;
            
            // 치즈가 녹은 후 새롭게 외부 공기(녹은 치즈로 인해 늘어난 공기 영역)를 확산시킴
            visited = new boolean[H][W];
            bfs(0, 0);
        }
        
        System.out.println(time);
        System.out.println(lastCheese);
    }
    
    // BFS : (r, c)에서 시작하여 외부 공기 영역(치즈가 아닌 영역)을 2로 채운다.
    public static void bfs(int r, int c) {
        Queue<Node> q = new ArrayDeque<>();
        visited[r][c] = true;
        q.add(new Node(r, c));
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            // 현재 칸이 0이면 공기이므로 2로 표시
            if (map[cur.r][cur.c] == 0) {
                map[cur.r][cur.c] = 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (isOut(nr, nc) || visited[nr][nc]) continue;
                // 치즈(1)가 아닌 경우에만 외부 공기로 확산
                if (map[nr][nc] != 1) {
                    visited[nr][nc] = true;
                    q.add(new Node(nr, nc));
                }
            }
        }
    }

    
    // 공기와 인접한 치즈 녹이기(2 옆에 있는 1를 2로 )
    public static void melt(int r, int c, boolean[][] visited) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (isOut(nr, nc)) continue;
            if (map[nr][nc] == 1) {
                map[nr][nc] = 2;
                visited[nr][nc] = true;
                meltingCnt++;
            }
        }
    }
    
    public static boolean isOut(int r, int c) {
        return r < 0 || r >= H || c < 0 || c >= W;
    }
    
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

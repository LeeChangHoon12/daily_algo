import java.io.*;
import java.util.*;

public class Solution {

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    static int[][] map;
    static int N, T;
    static int maxCore, minLength;
    static List<Node> list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine().trim());


        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine().trim());

            map = new int[N][N];
            list = new ArrayList<>();


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 가장 자리는 이미 연결되어 있으니까 넘기기
            for (int i = 1; i < N-1; i++) {
                for (int j = 1; j < N-1; j++) {
                    // 리스트에 추가
                    if(map[i][j] == 1)
                        list.add(new Node(i, j));
                }
            }

            maxCore = Integer.MIN_VALUE;
            minLength = Integer.MAX_VALUE;


            solve(0, 0, 0);


            System.out.println("#" + tc + " " + minLength);
        }
    }
    
    private static void solve(int idx, int coreCnt, int len) {
        // 모든 코어를 다 확인하면
        if(idx == list.size()) {
            // 근데 저번에 한거보다 많으면 
            if(maxCore < coreCnt) {
                maxCore = coreCnt; //최대 코어 갱신
                minLength = len; //최대 길이 갱신
            //같을 때는
            } else if(maxCore == coreCnt) {
                //전선 길이 합이 더 짧은 경우 갱신
                if(minLength > len) minLength = len;
            }
            return;
        }

        // 현재 처리할 코어의 위치
        int row = list.get(idx).r;
        int col = list.get(idx).c;

        // 4가지 방향(북, 동, 남, 서) 각각에 대해 시도
        for (int dir = 0; dir < 4; dir++) {
            int count = 0;   // 지금 방향에서 길이가 몇인지
            int nx = row;    // 시작 행
            int ny = col;    // 시작 열
            int Srow = row;  // 시작 행(저장 해놓기)
            int Scol = col;  // 시작 열 (저장해놓기)

            while(true) {
                //지금 가는 방향으로 계속 가면서
                nx += dx[dir];
                ny += dy[dir];

                //범위 확인
                if(isout(nx, ny)) break;
                
                //이미 코어 있으면 안됨
                if(map[nx][ny] == 1) {
                    count = 0;
                    break;
                }
                //끝까지가면 연결 가능한 경우임
                count++;
            }

            // 해당 라인 1로 표시해줌( 다른 라인이 못겹치게 표시)
            for (int i = 0; i < count; i++) {
                Srow += dx[dir];
                Scol += dy[dir];
                map[Srow][Scol] = 1; // 전선 놓기
            }

            // 전선 안 놓은 경우 => core 개수는 그대로 다음 코어 확인
            if(count == 0)
                solve(idx + 1, coreCnt, len);
            // 전선 놓으 경우 => core 더해주기랑 길이 더해줌
            else {
                // 전선을 놓은 경우: 연결된 코어 수 증가, 전선 길이 합 증가하여 다음 코어 처리
                solve(idx + 1, coreCnt + 1, len + count);

                // dfs 탐색 후 되돌리기 (백트래킹)
                // 놓았던 전선을 원래 상태(0)로 복원하기 위해 다시 반복문 실행
                Srow = row;
                Scol = col;
                for (int i = 0; i < count; i++) {
                    Srow += dx[dir];
                    Scol += dy[dir];
                    map[Srow][Scol] = 0; // 전선 제거 (원복)
                }
            }
        }
    }

    private static boolean isout(int nx, int ny) {
        return nx < 0 || nx >= N || ny < 0 || ny >= N;
    }

    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
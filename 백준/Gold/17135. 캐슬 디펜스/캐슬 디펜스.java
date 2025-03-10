import java.io.*;
import java.util.*;
/**
 * 격자판 N * M, 각 칸에 적이 최대 1마리 존재
 * 궁수 3명 배치 (궁수의 위치는 0~M-1 중 선택하며, 행은 N(캐슬행)로 고정)
 * [공격 규칙]
 *   - 각 궁수는 공격 거리 D 이하의 적 중 가장 가까운 적을 공격 (거리가 같다면 가장 왼쪽의 적 선택)
 *   - 같은 적이 여러 궁수에게 공격당할 수 있음 (한 턴에 중복 제거 불가)
 *   - 공격받은 적은 제거된다.
 * 턴이 진행될 때마다 적은 아래로 1칸 이동 (캐슬에 도달하면 게임에서 제외)
 * 모든 적이 제거되면 게임 종료
 *
 * 궁수 공격으로 제거할 수 있는 적의 최대 수를 구하는 문제
 */
public class Main {

    static int N, M, D;
    static int[][] map;
    static int[][] tmp;
    static int[] archers;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tmp = new int[N][M];
        archers = new int[3];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 필요에 따라 디버그용 출력 가능
        // for (int r = 0; r < N; r++) {
        //     for (int c = 0; c < M; c++) {
        //         System.out.print(map[r][c] + " ");
        //     }
        //     System.out.println();
        // }

        getPos(0, 0);
        System.out.println(max);
    }

    // 궁수의 위치(열)를 조합으로 뽑는 메서드
    public static void getPos(int depth, int start) {
        if (depth == 3) {
            // map을 tmp에 올바른 인덱스 순서로 복사
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    tmp[i][j] = map[i][j];
                }
            }
            int killCnt = 0;
            
            // 적이 남아있을 때까지 턴 진행
            while (true) {
                // 현재 보드에 적이 존재하는지 확인
                boolean enemyExists = false;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (tmp[i][j] == 1) {
                            enemyExists = true;
                            break;
                        }
                    }
                    if (enemyExists) break;
                }
                if (!enemyExists) break; // 적이 없으면 시뮬레이션 종료

                // 각 궁수별로 공격할 적 선정 (중복 제거를 위해 boolean 배열 사용)
                boolean[][] shot = new boolean[N][M];
                for (int a = 0; a < 3; a++) {
                    int archerCol = archers[a];
                    int minDist = Integer.MAX_VALUE;
                    int targetRow = -1;
                    int targetCol = -1;
                    // 보드 전체에서 적 탐색
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            if (tmp[i][j] == 1) {
                                int dist = Math.abs(N - i) + Math.abs(archerCol - j);
                                if (dist <= D) {
                                    // 더 가까운 적, 또는 같은 거리라면 왼쪽에 있는 적 선택
                                    if (dist < minDist) {
                                        minDist = dist;
                                        targetRow = i;
                                        targetCol = j;
                                    } else if (dist == minDist && j < targetCol) {
                                        targetRow = i;
                                        targetCol = j;
                                    }
                                }
                            }
                        }
                    }
                    if (targetRow != -1) {
                        shot[targetRow][targetCol] = true;
                    }
                }
                // 공격받은 적 제거
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (shot[i][j] && tmp[i][j] == 1) {
                            tmp[i][j] = 0;
                            killCnt++;
                        }
                    }
                }
                // 적 이동: 아래로 한 칸씩 이동 (가장 아래 행은 제거)
                for (int i = N - 1; i >= 1; i--) {
                    for (int j = 0; j < M; j++) {
                        tmp[i][j] = tmp[i - 1][j];
                    }
                }
                // 맨 위 행은 빈 칸으로 채움
                for (int j = 0; j < M; j++) {
                    tmp[0][j] = 0;
                }
            }
            max = Math.max(max, killCnt);
            return;
        }
        // 조합으로 궁수의 열 위치 선택
        for (int i = start; i < M; i++) {
            archers[depth] = i;
            getPos(depth + 1, i + 1);
        }
    }
}

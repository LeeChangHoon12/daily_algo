import java.util.*;
import java.io.*;


public class Main {

    static int N;
    // 반 좌석 배치
    static int[][] map;
    // 좋아하는 학생들
    static int[][] studentsInfo;
    // 학생 순서
    static int[] studentsSeq;

    // 상, 하, 좌, 우
    static int[] dirR = { -1, 1, 0, 0 };
    static int[] dirC = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        // 입력을 받는함수
        input();

        // 학생 n번부터 자리배치 시작.
        for (int n : studentsSeq) {
            // 자리 배치
            seatArrange(n);
        }

        // 만족도 조사
        int ans = satisfactionCheck();
        System.out.println(ans);

    }



    //학생 자리 배치
    public static void seatArrange(int student) {

    	//각 자리(Node)의 정보를 나타내는 Node를 리스트에 담는다.
        ArrayList<Node> list = new ArrayList<>();

        //모든 교실의 자리를 돌면서, 현재 학생(parameter의 student) 기준으로 빈칸과 좋아하는 사람이 들어갈 수 있는 기준을 만들어줌.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 0) {
                    // 4방향 탐색
                    int blankSeatCnt = 0;
                    int likeCnt = 0;
                    // 네 방향으로 탐색하면서
                    // 빈칸 개수와 좋아하는 사람 수를 저장
                    for (int d = 0; d < 4; d++) {
                        int nextR = i + dirR[d];
                        int nextC = j + dirC[d];

                        // 범위 벗어나면 안함
                        if (!isIn(nextR, nextC))
                            continue;
                        // 빈칸 체크
                        if (map[nextR][nextC] == 0) {
                            blankSeatCnt++;
                        }

                        // 좋아하는 사람 체크
                        for (int k = 0; k < 4; k++) {
                            if (map[nextR][nextC] == studentsInfo[student][k]) {
                                likeCnt++;
                            }
                        }
                    }
                    
                    //node에는 그 자리에 대한, 좋아하는 학생수, 빈칸 수가 들어가게됨.
                    //추후 문제 조건을 기준으로 정렬해서 0에있는게 우선순위가 가장 높은것.
                    list.add(new Node(i, j, likeCnt, blankSeatCnt));
                }
            }
        }

        //list를 정렬
        Collections.sort(list);

        map[list.get(0).r][list.get(0).c] = student;
    }

    // 범위 나갔는지 확인하는 함수
    public static boolean isIn(int r, int c) {
        return 1 <= r && r <= N && 1 <= c && c <= N;
    }

    // 입력받는 함수
    // 반의 좌측 상단이 (1,1) 부터 시작함을 맞춰주었다
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        studentsInfo = new int[N * N + 1][4];
        studentsSeq = new int[N * N];
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());

            int student = Integer.parseInt(st.nextToken());
            studentsSeq[i] = student;
            for (int j = 0; j < 4; j++) {
                studentsInfo[student][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
    
    //만족도 검사
    public static int satisfactionCheck() {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int studentNum = map[i][j];
                int likeCnt = 0;
                for (int d = 0; d < 4; d++) {

                    int nextR = i + dirR[d];
                    int nextC = j + dirC[d];

                    if (!isIn(nextR, nextC))
                        continue;
                    // 해당 행열에 앉은 학생의 주변에 좋아하는 사람이 몇명인지 카운팅
                    for (int k = 0; k < 4; k++) {
                        if (map[nextR][nextC] == studentsInfo[studentNum][k]) {
                            likeCnt++;
                        }
                    }
                }
                //카운팅 해준 값을 치환해서 sum에 더해줌
                if (likeCnt == 1) {
                    sum += 1;
                    continue;
                } else if (likeCnt == 2) {
                    sum += 10;
                    continue;
                } else if (likeCnt == 3) {
                    sum += 100;
                    continue;
                } else if (likeCnt == 4) {
                    sum += 1000;
                    continue;
                }
            }
        }

        return sum;

    }
    
}

// Comparable의 compareTO를 overrid해서 
//Node를 가지고있는 list를 sort할때, 높은 좋아하는 학생 수, 높은 빈칸 수, 낮은 행, 낮은 열 기준으로 정렬되도록함.
//순서가 우선순위가 되기때문에, 조건문의 순서 중요!!!!!
class Node implements Comparable<Node> {
    int r;
    int c;
    int likeCnt;
    int blankCnt;

    public Node(int r, int c, int likeCnt, int blankCnt) {
        this.r = r;
        this.c = c;
        this.likeCnt = likeCnt;
        this.blankCnt = blankCnt;
    }

    // if문의 순서도 중요함
    @Override
    public int compareTo(Node o) {

        if (likeCnt != o.likeCnt) {
            // likeCnt 내림차순으로
            return Integer.compare(o.likeCnt, likeCnt);
        }

        if (blankCnt != o.blankCnt) {
            // blankCnt 내림차순으로
            return Integer.compare(o.blankCnt, blankCnt);
        }

        if (r != o.r) {
            // 행 오름차순
            return Integer.compare(r, o.r);
        }

        // 열도 오름차순
        return Integer.compare(c, o.c);

    }

}

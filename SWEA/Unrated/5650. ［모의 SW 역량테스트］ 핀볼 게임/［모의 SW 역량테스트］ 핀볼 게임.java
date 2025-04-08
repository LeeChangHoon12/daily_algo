import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
* 핀볼1~5까지는 벽
* 6  ~ 10 웜홀
* -1 블랙홀
*
* 웜홀이나 블랙홀을 만나기전까지 그 방향으로 계속 감
* 수평벽(5)은 반대방향, 수직벽 -> 직각으로 방향 변환
*
* 웜홀은 쌍으로 주어짐, 웜홀에 닿으면 같은 번호 웜홀로 위치 변경(진행 방향 그대로 6~10)
* 블랙홀 만나면 게임 끝
* 출발 위치로 돌아오거나, 블랙홀에 닿으면 끝
* 점수 = 벽이나 블록에 부딪힌 횟수(웜홀은 계산x)
*
* 게임에서 얻을 수 있는 최댓값
*
*
* */
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    //상, 하, 좌, 우 0,1,2,3
    static int[] dirR = {-1,1,0,0};
    static int[] dirC = {0,0,-1,1};


    static int result;
    static int tmpScore;
    static int[][] map;
    static int N;

    //static boolean[][] wormholeList;
    static List<WormHole> wormholeList;
    static boolean[][] blackholeList;

    static Ball ball;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());
        for(int t=1; t<=T; t++){
            input();

            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(map[r][c] == 0){
                        for(int d=0; d<4; d++){
                            ball = new Ball(r,c,d);
                            tmpScore = 0;
                            gameStart(r,c);
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + result);

        }
    }

    public static void input() throws Exception {

        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];
        wormholeList = new ArrayList<>();
        blackholeList = new boolean[N][N];
        result = 0;

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine().trim());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                //웜홀 세팅
                if( map[r][c] >= 6 && map[r][c] <= 10){
                    wormholeList.add(new WormHole(r,c,map[r][c]));
                }
                //블랙홀 세팅
                if(map[r][c] == -1){
                    blackholeList[r][c] = true;
                }

            }
        }

    }

    public static void gameStart(int startR, int startC){

        //System.out.print(ball.d + " ");

        a : while(true){

           // System.out.println("ㅁㄴㅇㅁㅇㄴㅇㄴㅁㅇ!!! " + ball.d);
            ball.r =  ball.r + dirR[ball.d];
            ball.c =  ball.c + dirC[ball.d];
            //System.out.println(ball.r + "  " + ball.c + "  " +  ball.d);
            //벽임 -> 방향 반대로 바꾸고 점수 +1
            if(isOut(ball.r, ball.c )){

                tmpScore++;

                //공이 위 방향 > 하로 바꾸기
                if(ball.d == 0){
                    ball.d = 1;
                    continue a;

                }
                //공이 아래 방향 > 상로 바꾸기
                if(ball.d == 1){
                    ball.d = 0;
                    continue a;
                }
                //공이 우 방향 > 좌로 바꾸기
                if(ball.d == 3){
                    ball.d = 2;
                    continue a;
                }
                //공이 좌 방향 > 우으로 바꾸기
                if(ball.d == 2){
                    ball.d = 3;
                    continue a;
                }


            }


            //블랙홀에 들어감 || 시작점으로 돌아옴
            if(blackholeList[ball.r][ball.c] || (ball.r == startR && ball.c == startC)){

                //System.out.println(startR + " , " + startC + " " + ball.d+" ########탈출########## " + tmpScore);
                //점수 갱신
                result = Math.max(result,tmpScore);
                break;
            }

            //웜홀에 들어감 => 다른 웜홀로 이동
            for(WormHole worm : wormholeList){
                if(worm.c == ball.c && worm.r == ball.r){
                    for(WormHole tmpWorm : wormholeList){
                        if(tmpWorm.num == worm.num){
                            if(tmpWorm.r != ball.r || tmpWorm.c != ball.c){
                                ball.r = tmpWorm.r;
                                ball.c = tmpWorm.c;
                                continue a;
                            }
                        }
                    }
                }
            }

            //블록에 부딪
            if(map[ball.r][ball.c] >=1 && map[ball.r][ball.c] <= 5){
                tmpScore++;
                changeDir(map[ball.r][ball.c]);
            }



        }
    }

    public static boolean isOut(int nowR, int nowC){
        return nowR < 0 || nowR >= N || nowC < 0 || nowC >= N;
    }


    public static void changeDir(int wall){

        //상0 하1 좌2 우3
        if(wall == 1){

            //공이 위 방향 > 아래로 바꾸기
            if(ball.d == 0) {
                ball.d = 1;
                return;
            }
            //공이 아래 방향 > 우로 바꾸기
            if(ball.d == 1) {
                ball.d = 3;
                return;
            }
            //공이 우 방향 > 좌로 바꾸기
            if(ball.d == 3) {
                ball.d = 2;
                return;
            }
            //공이 좌 방향 > 상으로 바꾸기
            if(ball.d == 2) {
                ball.d = 0;
                return;
            }

        }else if(wall == 2){
            //공이 위 방향 > 우 바꾸기
            if(ball.d == 0) {
                ball.d = 3;
                return;
            }

            //공이 아래 방향 > 상 바꾸기
            if(ball.d == 1) {
                ball.d = 0;
                return;
            }
            //공이 우 방향 > 좌 바꾸기
            if(ball.d == 3) {
                ball.d = 2;
                return;
            }
            //공이 좌 방향 > 하 바꾸기
            if(ball.d == 2) {
                ball.d = 1;
                return;
            }

            //상0 하1 좌2 우3
        }else if(wall == 3){
            //공이 위 방향 > 좌로 바꾸기
            if(ball.d == 0) {
                ball.d = 2;
                return;
            }
            //공이 아래 방향 > 상 바꾸기
            if(ball.d == 1) {
                ball.d = 0;
                return;
            }
            //공이 우 방향 > 하로 바꾸기
            if(ball.d == 3) {
                ball.d = 1;
                return;
            }
            //공이 좌 방향 > 우으로 바꾸기
            if(ball.d == 2) {
                ball.d = 3;
                return;
            }

            //상0 하1 좌2 우3
        }else if(wall == 4){
            //공이 위 방향 > 하로 바꾸기
            if(ball.d == 0) {
                ball.d = 1;
                return;
            }
            //공이 아래 방향 > 좌 바꾸기
            if(ball.d == 1) {
                ball.d = 2;
                return;
            }
            //공이 우 방향 > 상로 바꾸기
            if(ball.d == 3) {
                ball.d = 0;
                return;
            }
            //공이 좌 방향 > 우으로 바꾸기
            if(ball.d == 2) {
                ball.d = 3;
                return;
            }

            //상0 하1 좌2 우3
        }else if(wall == 5){
            //공이 위 방향 > 하로 바꾸기
            if(ball.d == 0) {
                ball.d = 1;
                return;
            }
            //공이 아래 방향 > 상로 바꾸기
            if(ball.d == 1) {
                ball.d = 0;
                return;
            }
            //공이 우 방향 > 좌로 바꾸기
            if(ball.d == 3) {
                ball.d = 2;
                return;
            }
            //공이 좌 방향 > 우으로 바꾸기
            if(ball.d == 2) {
                ball.d = 3;
                return;
            }
        }


    }


    static class Ball{
        int r;
        int c;
        int d;

        public Ball(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d= d;
        }
    }

    static class WormHole{
        int r;
        int c;
        int num;

        public WormHole(int r,int c, int num){
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }


}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //상, 우, 하, 좌
    static int[] dirR = {-1,0,1,0};
    static int[] dirC = {0,1,0,-1};
    static int C;
    static int R;
    static int[][] map;
    static boolean[][] visit;
    static int moveCnt;
    static int dirIndex;
    static int targetNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        targetNum = Integer.parseInt(br.readLine());


        map = new int[R][C];
        visit = new boolean[R][C];

        int startR = R-1;
        int startC = 0;

        dirIndex = 0;
        moveCnt = 1;
        start(startR,startC);

    }

    public static void start(int r, int c){

        if(moveCnt > R*C){
            System.out.println(0);
            return;
        }

        map[r][c] = moveCnt;
        visit[r][c] = true;

        if(map[r][c] == targetNum){
            System.out.println((c+1)+ " " + (R-r));
            return;
        }

        int nextR = r + dirR[dirIndex];
        int nextC = c + dirC[dirIndex];

        if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C || visit[nextR][nextC]){
            dirIndex = (dirIndex+1) % 4;
            nextR = r + dirR[dirIndex];
            nextC = c + dirC[dirIndex];
            moveCnt++;
            start(nextR,nextC);

        }else{
            moveCnt++;
            start(nextR,nextC);
        }


    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int M;
    static int N;

    static int[][] map;
    static boolean[][] visit;

    static Queue<Pos> que = new LinkedList<>();
    static int[] dir_x = {0,0,1,-1};
    static int[] dir_y = {1,-1,0,0};


    public static void main(String[] args) throws IOException {
        //0 이동불가
        //1 이동가능
        //(1,1)에서 출발 (N,M)의 위치로 이동 최소 칸 수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M]; //미로
        visit = new boolean[N][M]; //방문여부

        //미로 세팅
        for(int i=0; i<N; i++){
            //st = new StringTokenizer(br.readLine(),"");
            String line = br.readLine();
            for(int j=0; j<M ;j++){
                map[i][j] = line.charAt(j) -'0';
            }
        }

        //최단 거리 탐색 시작
        bfs(0,0);




        System.out.print(map[N-1][M-1]);
    }


    //너비 우선 탐색 (N-1,M-1)에 도착하면 종료
    public static void bfs(int x, int y){

        que.add(new Pos(x,y));
        visit[x][y] = true;

        while(!que.isEmpty()){
            Pos current_pos = que.poll();

            int current_x = current_pos.x ;
            int current_y = current_pos.y;

            for(int i=0; i<4;i++){
                int next_x = current_x + dir_x[i];
                int next_y = current_y + dir_y[i];

                if(next_x < 0 || next_x >= N || next_y < 0 || next_y >= M){
                    continue;
                }

                if(visit[next_x][next_y]){
                    continue;
                }

                if(map[next_x][next_y] == 0){
                    continue;
                }


                que.add(new Pos(next_x,next_y));
                visit[next_x][next_y] = true;
                map[next_x][next_y] = map[current_x][current_y] + 1;

            }
        }
    }
}

class Pos{
    int x;
    int y;

    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}

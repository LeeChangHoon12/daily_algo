import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dir_z = {-1,1,0,0,0,0};
    static int[] dir_x = {0,0,1,-1,0,0};
    static int[] dir_y = {0,0,0,0,1,-1};

    static int[][][] tomatoBox;
    static Queue<Tomato> tomato_after = new LinkedList<>();


    static int M,N,H;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken()); // = y축
        M = Integer.parseInt(st.nextToken()); // = x축
        H = Integer.parseInt(st.nextToken()); // = z축

        tomatoBox = new int[H][M][N]; //3차원 행렬 -> x,y,z축 생각 필요..

        int total_tomato = 0;

        boolean already = true;

        //토마토 입력받기
        for(int i=0; i<H; i++){
            for(int j=0; j<M; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<N; k++){
                    //0은 안익은 토마토, -1은 토마토가 없음, 1은 익은 토마토
                    tomatoBox[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomatoBox[i][j][k] == 1){
                        tomato_after.add(new Tomato(i,j,k)); //익은 토마토 추가
                    }else if(tomatoBox[i][j][k] == 0){
                        already = false;
                    }
                }
            }
        }

        //시작부터 모두 익어있는 상태
        if(already){
           System.out.println(0);
           return;
        }

        bfs();

        int result = 0;
        boolean exist = false;

        for(int i=0; i<H; i++){
            for(int j=0; j<M; j++){
                for(int k=0; k<N; k++){
                    //0은 안익은 토마토, -1은 토마토가 없음, 1은 익은 토마토
                    result = Math.max(tomatoBox[i][j][k],result);

                    //안익은 토마토가 있으면
                    if(tomatoBox[i][j][k] == 0){
                        exist = true;
                    }

                }
            }
        }
        if(exist){
            System.out.print(-1);
        }else{
            System.out.println(result-1);
        }

    }

    //익은 토마토 큐에서만 bfs 시작 -> 다 돌았을때 날짜 -> 다 익은 최소 날짜 출력
    //다 돌앗는데 덜익은 토마토 남음 -> -1출력
    //토마토 개수 = 익은 토마토 개수 -> 0 출력



    //큐에 토마토가 있는 동안 반복
    //1. 큐에서 토마토 가져옴
    //2. 6방향(x,y,z 방향) 체크
    // 다음 방향이 범위안에 들어오는지 체크
    // 안익은 토마토 인지 확인

    //범위에 들어오고 안익은 토마토라면
    //덜익은 토마토--
    //익은 토마토로 체크
    //익은 토마토는 상하좌우 토마토를 또 익혀야하니, 큐에 넣어줌

    public static void bfs(){


        while(!tomato_after.isEmpty()){

            //현재 토마토 위치
            Tomato current_tomato = tomato_after.poll();
            int cur_z = current_tomato.z;
            int cur_x = current_tomato.x;
            int cur_y = current_tomato.y;

            //다음 토마토 위치
            for(int i=0; i<6; i++){
                int next_z = cur_z + dir_z[i];
                int next_x = cur_x + dir_x[i];
                int next_y = cur_y + dir_y[i];

                //범위 체크
                if(next_z >= H || next_z <0 || next_x >= M || next_x < 0 || next_y >= N || next_y < 0){
                    continue;
                }

                //다음 토마토가 안익은 토마토일 때만, 큐에 넣어줘야함
                // -1 이면 토마토가 없는 경우임..
                if(tomatoBox[next_z][next_x][next_y] == 0){
                    tomato_after.add(new Tomato(next_z,next_x,next_y));
                    //날짜 체크를 위해서 +1
                    //bfs를 해서 이 전 토마토 번호 +1하면 며칠 째되는 날 익었는지 알 수 있음(1부터 시작했으니 결과에 -1 필요)
                    tomatoBox[next_z][next_x][next_y] = tomatoBox[cur_z][cur_x][cur_y] + 1;
                }
            }

        }

    }
}

class Tomato {
    public int z;
    public int x;
    public int y;

    public Tomato(int z, int x, int y){
        this.z = z;
        this.x = x;
        this.y = y;
    }
}

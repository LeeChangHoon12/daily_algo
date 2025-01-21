
import java.util.*;
import java.io.*;

public class Main {

    static int w;
    static int h;
    static char[][] map;
    static int[][] move_log;

    static int[] dir_x = {0,0,-1,1};
    static int[] dir_y = {1,-1,0,0};
    
    static Queue<Fire> fires_que = new LinkedList<>();
    static Queue<Move> move_que = new LinkedList<>();
    static boolean[][] visited;


    static boolean isPossible;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());



        for(int t=0; t<test_case; t++){

            isPossible = false;
            
            
            fires_que.clear();
            move_que.clear();

            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
	
						
            map = new char[h][w];
            move_log = new int[h][w]; //최소 이동 거리 저장할 배열
            visited = new boolean[h][w];

            for(int i=0; i<h; i++){
                String line = br.readLine();
                for(int j=0; j<w; j++){
                    map[i][j] = line.charAt(j);
                }
            }

            
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j] == '*'){
                        //System.out.println(map[i][j]);
                        fires_que.add(new Fire(i,j));  //이동할 불 후보 큐
                        visited[i][j] = true;
                    }

                    if(map[i][j] == '@'){
                        //System.out.println(map[i][j]);
                        move_que.add(new Move(i,j)); //사람 이동할 위치 큐
                        move_log[i][j] = 1; // 이동 시작점
                        visited[i][j] = true;
                    }
                }
            }

            
            bfs();
            	
            int max = 0;            
            if(isPossible) {                
                for(int i=0; i<h; i++) {
                	for(int j=0; j<w; j++) {                		
                		max = Math.max(max,move_log[i][j]);
                	}
                }                
        		System.out.println(max);
        		
            }else {
            	System.out.println("IMPOSSIBLE");
            }
        
        }
    }


    public static void bfs(){

				//사람이 이동할 곳이 없을 때 까지 반복 
        while(!move_que.isEmpty()){
            //Queue<Fire> next_fires = new LinkedList<>();
        	Queue<Fire> next_fires = new LinkedList<>();

            //불을 넣어
            while(!fires_que.isEmpty()){
            	next_fires.add(fires_que.poll());
            }

            //가능한 방향으로 불 옮기기
            while(!next_fires.isEmpty()){
          
                //다음 불 큐에서 가져오기
                Fire current_fire = next_fires.poll();
                
                //지금 있는 불에서 옮기기 
                for(int i=0; i<4; i++){
                    int nx = current_fire.x + dir_x[i];
                    int ny = current_fire.y + dir_y[i];

                    if(nx < 0 || nx >= h || ny < 0 || ny >= w){
                        continue;
                    }

                    //이미 불이거나, 벽이거나(빈 공간이거나, 사람일 떄만 불이 번져야함)
                    if(map[nx][ny] == '*' || map[nx][ny] == '#'){
                        continue;
                    }

                    //불 번짐
                    map[nx][ny] = '*';
                    visited[nx][ny] = true;                    
                    
                    //다음 번에 번지게하도록 tmp_fire
                    fires_que.add(new Fire(nx,ny));
                }
            }

           
            
            Queue<Move> next_move = new LinkedList<>();
            
           
            while(!move_que.isEmpty()){
                next_move.add(move_que.poll());
            }


            while(!next_move.isEmpty()){
            	
                Move current_move = next_move.poll();
                for(int i=0; i<4;i++){
                    int nx = current_move.x + dir_x[i];
                    int ny = current_move.y + dir_y[i];


										//이동 범위 체크 
                    if(nx < 0 || nx >= h || ny < 0 || ny >= w){
                    	isPossible = true;
                        return;
                    }
                    
                    //불, 사람(이미 갔던 곳), 벽은 패스 
                    if(map[nx][ny] == '*' || map[nx][ny] == '@' || map[nx][ny] == '#') {
                    	continue;
                    }

                    
                    //빈 공간일 때만, 
                    if(!visited[nx][ny]) {
                    
		                  //이동 체크 
                    	map[nx][ny] = '@';
                		visited[nx][ny] =true;
                    	
                    	//이동 횟수 기록 
                    	move_log[nx][ny] = move_log[current_move.x][current_move.y] + 1;                  	
                    	//다음 이동 경로 추가  
                    	move_que.add(new Move(nx, ny));
	                      
                      //탈출구에 도착하면
                      if(nx == h-1 || ny == w-1 || nx == 0 || ny == 0){
                          isPossible = true;
                          return;
   
                      }
                    }
                }
            }            
        }

    }
}

class Fire{
    int x;
    int y;
    public Fire(int x, int y){
        this.x = x;
        this.y = y;
    }
}


class Move{
    int x;
    int y;

    public Move(int x, int y){
        this.x = x;
        this.y = y;
    }
}

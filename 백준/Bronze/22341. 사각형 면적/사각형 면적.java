import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<int[]> pos = new ArrayList<>();
    static int[][] map;
    static int posX;
    static int posY;
    static int width;
    static int height;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        for(int c=0; c<C; c++){
            st = new StringTokenizer(br.readLine());
            pos.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        map = new int[N][N];

        width = N;
        height = N;

        for(int c=0; c<C; c++){
            posX = pos.get(c)[0];
            posY = pos.get(c)[1];

            if(posX < 0 || posX >= N || posY < 0 || posY >= N){
                continue;
            }

            //세로로 자른 종이 넓이
            int area1 = height * posY;

            //가로로 자른 종이 넓이
            int area2 = width * posX;

            //가로로 자른게 넓이가 크거나, 같다면
            if(area2 > area1 || area1 == area2){
                height = posX;
            }else{
                width = posY;
            }

        }


        System.out.print(height * width);



    }
}

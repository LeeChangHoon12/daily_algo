import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int maxWidth = 0;
    static int maxHeight = 0;
    static int widthIndex = 0;
    static int heightIndex = 0;

    static int[] map = new int[6];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        //1,2 : 동,서
        //3,4 : 남,북


        for(int i=0; i<6; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            map[i] = len;

            if(dir == 1 || dir == 2){
                if(len >= maxWidth){
                    maxWidth = len;
                    widthIndex = i;
                }
            }else{
                if(len >= maxHeight){
                    maxHeight = len;
                    heightIndex = i;
                }
            }
        }

        //최대 넓이 양쪽 인덱스 서로 마이너스에 절대값
        int width = 0;
        if(widthIndex == 5){
            width = Math.abs(map[0] - map[4]);
        }else if(widthIndex == 0){
            width = Math.abs(map[1] - map[5]);
        }else{
            width = Math.abs(map[widthIndex-1] - map[widthIndex+1]);
        }



        //최대 높이 양쪽 인덱스 서로 마이너스에 절대값
        int height = 0;
        if(heightIndex == 5){
            height = Math.abs(map[0] - map[4]);
        }else if(heightIndex == 0){
            height = Math.abs(map[1] - map[5]);
        }else{
            height = Math.abs(map[heightIndex-1] - map[heightIndex+1]);
        }

        int area = maxHeight * maxWidth - height * width;
        System.out.println(area * K);

    }
}

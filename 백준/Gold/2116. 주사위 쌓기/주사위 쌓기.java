import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] pairs = new int[]{5,3,4,1,2,0};
    static int[] result;
    static int[][] dice;
    static int N;
    static int max = 0;
    static int tmpMax = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        result = new int[N];
        dice = new int[N][6];


        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++){
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;
        for(int i=1; i<=6; i++){
            result = new int[N];
            tmpMax = 0;
            //아랫이 1 부터 시작
            stack(i,0);
            //System.out.println("시작 밑면 " + i  +" : "+ tmpMax + " ");
            max = Math.max(tmpMax,max);
        }

        System.out.println(max);

    }

    public static void stack(int num,int level){


        if(level == N){
            return;
        }

        int bottom = 0;

        for(int i=0; i<6; i++){
            if(dice[level][i] == num){
                bottom = i;
            }
        }

        int top = pairs[bottom];

        //아랫면 윗면 세팅

        //윗면 인덱스

        for(int i=0; i<6; i++){
            //윗면, 아랫면 제외
            if(i == top || i == bottom){
                //옆면 최대값 갱신
                continue;
            }else{
                result[level] = Math.max(result[level],dice[level][i]);
            }
        }

        //현재 층에서 옆면 최대값
        tmpMax += result[level];
        //System.out.print(tmpMax + "(" + result[level] + " " + bottom + " " + top +  ") ");


        stack(dice[level][top],level+1);

    }
}

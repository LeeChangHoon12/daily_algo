import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 18장의 카드로 게임
 * 각자 9장씩 나누기
 *
 * 9라운드 진행
 *
 * 라운드별로
 *  두 사람의 카드 비교
 *  높은 수가 적힌 카드를 낸사람은 두카드의 합 만큼 점수를 얻고
 *  낮은 수가 적힌 카드를 낸사람은 점수 X
 *
 *  9라운드 후 총점이 높은 사람이 이김
 *  총점이 같으면 무승부
 *
 *  규영이가 받은 9장
 *
 * */

public class Solution {
    static int A;
    static int B;

    static ArrayList<Integer> Acards;
    static ArrayList<Integer> Bcards;

    static int win;
    static int lose;

    static boolean[] Avisited;
    static boolean[] Bvisited;

    static int[] Bresult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T; tc++){

            int arr[] = new int[19];
            win = 0;
            lose = 0;
            Acards = new ArrayList<>();
            Bcards = new ArrayList<>();
            Bvisited = new boolean[9];
            Bresult = new int[9];


            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=9; i++){
                arr[Integer.parseInt(st.nextToken())] = 1;
            }

            for(int i=1;i<=18;i++){
                if(arr[i] == 1){
                    Acards.add(i);
                }else{
                    Bcards.add(i);
                }
            }

            check(0);
            System.out.println("#" + tc + " " + win + " " + lose);
        }
    }

    public static void check(int depth){

        if(depth == 9){
            int Asum = 0;
            int Bsum = 0;

//            for(int i=0; i<9; i++){
//                System.out.print(Bresult[i] + " ");
//            }
//            System.out.println();
            //a와 b 카드 비교
            for(int i=0; i<9; i++){
                //규영이가 이김
                if(Acards.get(i) > Bresult[i]){
                    Asum += Acards.get(i) + Bresult[i];
                }else if(Acards.get(i) < Bresult[i]){
                    Bsum += Acards.get(i) + Bresult[i];
                }
            }

            if(Asum > Bsum){
                win++;
            }else if(Asum < Bsum){
                lose++;
            }

            return;
        }

        for(int i=0; i<9; i++){
            if(!Bvisited[i]){
                Bvisited[i] = true;
                Bresult[depth] = Bcards.get(i);
                check(depth+1);
                Bvisited[i] = false;
            }
        }

    }
}

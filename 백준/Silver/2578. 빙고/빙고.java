import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] check = new boolean[26];
    static int [][]  bingo = new int[5][5];
    static int result = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                int num = Integer.parseInt(st.nextToken());
                bingo[i][j] = num;
            }
        }

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                int callNum = Integer.parseInt(st.nextToken());

                check[callNum] = true;
                result++;
                //부른 숫자 포함해서 빙고 됬는지 확인
                if(bingoCount()){ //빙고 됬으면
                    System.out.println(result);
                    return;
                }
            }
        }
    }


    public static boolean bingoCount(){

        int bingoCount = 0;
        int count = 0;

        //행 기준 빙고 있는지 확인

        for(int i=0; i<5; i++){
            count = 0;
            for(int j=0; j<5; j++){
                if(check[bingo[i][j]]){
                    count++;
                }
            }
            if(count == 5){
                bingoCount++;
            }
        }


        for(int i=0; i<5; i++){
            count = 0;
            for(int j=0; j<5; j++){
                if(check[bingo[j][i]]){
                    count++;
                }
            }
            if(count == 5){
                bingoCount++;
            }
        }

        count = 0;
        int r = 0;
        int c = 0;
        for(int i=0; i<5; i++){
            if(check[bingo[r][c]]){
                count++;
            }
            if(count == 5){
                bingoCount++;
            }
            r++;
            c++;
        }

        count = 0;
        r=4;
        c=0;
        for(int i=0; i<5; i++){
            if(check[bingo[r][c]]){
                count++;
            }
            if(count == 5){
                bingoCount++;
            }
            r--;
            c++;
        }

       // System.out.println(bingoCount);
        return bingoCount >= 3;

    }


}

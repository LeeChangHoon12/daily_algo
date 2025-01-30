import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x1 = Integer.parseInt(br.readLine());

        int maxX2 = 0;
        int max = 0;

        for(int i=1; i<=x1; i++ ){
            count = 1;
            rec(x1,i);
            if(max <= count){
                max = count;
                maxX2 = i;
            }
        }

        System.out.println(max);
        recPrint(x1,maxX2);

    }

    public static void rec(int x1,int x2){
        count++;
        if(x1 - x2 < 0){

            return;
        }


        rec(x2,x1-x2);
    }

    public static void recPrint(int x1, int x2){
        if(x1 - x2 < 0){
            System.out.println(x1 + " " + x2);
            return;
        }

        System.out.print(x1 + " ");
        recPrint(x2,x1-x2);
    }
}

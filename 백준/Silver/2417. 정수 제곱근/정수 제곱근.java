import java.util.Scanner;

public class Main{
    static long N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();

        long start = 0;
        long end = N;


        while(start+1 < end){
            long q = (start+end)/2;
            if(check(q)){
                end = q;
            }else{
                start = q;
            }
        }

        System.out.print(end);

    }



    public static boolean check(long q){

        return Math.pow(q,2) >= N;

    }
}

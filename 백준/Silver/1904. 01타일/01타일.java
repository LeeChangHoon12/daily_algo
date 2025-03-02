import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[1000001];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        if(N == 1 || N == 2){
            System.out.print(dp[N]);
            return;
        }

        for(int i = 3; i <= 1000000; i++){
            dp[i] = (dp[i-2] + dp[i-1])%15746;
        }

        System.out.print(dp[N]);
    }
}

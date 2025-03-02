import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] memo;
    static int[] stair;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        stair = new int[n+1];
        memo = new int[n+1];

        Arrays.fill(memo,-1);



        for(int i = 1; i <= n; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }


        memo[1] = stair[1];
        if(n == 1){
            System.out.println(memo[n]);
            return;
        }
        memo[2] = stair[1] + stair[2];
        if(n == 2){
            System.out.println(memo[n]);
            return;
        }
        memo[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);


        System.out.println(dp(n));


    }

    static int dp(int n){
        if(memo[n] != -1){
            return memo[n];
        }

        if(n == 1 || n == 2 || n == 3){
            return memo[n];
        }

        memo[n] = Math.max(dp(n-2) + stair[n], dp(n-3)  + stair[n-1]+ stair[n]);
        return memo[n];
    }
}

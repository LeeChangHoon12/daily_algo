import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] t = new int[n];
        int[] p = new int[n];

        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(reader.readLine());

            //상담기간
            t[i] = Integer.parseInt(st.nextToken());
            //금액
            p[i] = Integer.parseInt(st.nextToken());
        }

        //최대 금액
        int[] dp = new int[n+1];

        //dp[i + t[i]] = max(dp[i + t[i]], dp[i] + p[i]);
        for (int i=0; i<n; i++) {
            if (i + t[i] <= n) {
                //날짜가 범위를 넘어가지 않는 경우
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            
            //해당 날짜에 일할 수 없다면, 이전까지 일한 최대 수당을 넣어주어야 한다.
            dp[i+1] = Math.max(dp[i+1], dp[i]); //일 안하는 경우
        }
        System.out.println(dp[n]);
    }
}

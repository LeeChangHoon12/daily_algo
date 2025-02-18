import java.io.*;
import java.util.StringTokenizer;

/**
 * N개의 정수 수열
 * 크기가 양수인 부분수열 중 원소의 합이 S인 경우의 수
 *
 * 입력 : N(정수의 갯수),S(합 목표)
 *
 *
 * */

public class Main {
    static int N;
    static int S;
    static int[] arr;
    static int[] result;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        result = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        dfs(0, 0);

        System.out.println(cnt);



    }

    static void dfs(int depth, int sum) {
        if (depth == N) {
            return;
        }
        if(sum+arr[depth] == S){
            cnt++;
        }

        dfs(depth+1,sum);
        dfs(depth+1,sum+arr[depth]);
    }
}
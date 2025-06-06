import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];
        for(int i=0; i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0,0);
    }

    public static void dfs(int start,int depth){
        if(depth == M){
            for(int i=0; i<M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<N; i++){
            result[depth] = arr[i];
            dfs(i+1,depth+1);
        }

    }
}

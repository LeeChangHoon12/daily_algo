
import java.util.*;
import java.io.*;



public class Main {

    //주어진 N개의 수
    static ArrayList<Integer> arr = new ArrayList<>();
    static int N; //입력 N (N개의 자연수)
    static int M; //결과 수열 길이 M
    static int[] result;


    static boolean[] visited;

    public static void main(String[] args)throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        // 비내림차순을 위한 정렬
        arr.sort(Comparator.naturalOrder());

        visited = new boolean[N];
        result = new int[M];

        int lasted = 0;

        dfs(0,0);

    }
    
    static void dfs(int start, int depth) {
        if(depth == M) {
            for(int i=0; i<result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int j=start; j<N; j++) {
            result[depth] = arr.get(j);
            dfs(j,depth+1);
        }
    }
}
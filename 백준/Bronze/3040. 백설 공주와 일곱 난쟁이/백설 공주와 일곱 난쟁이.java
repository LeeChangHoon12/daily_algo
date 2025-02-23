import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int sum;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        arr = new int[9];
        visited = new boolean[9];
        result = new int[7];
        for(int i=0; i<9; i++){
            arr[i] = sc.nextInt();
        }

        dfs(0, 0);

    }

    public static void dfs(int depth, int start){
        if(flag){
            return;
        }
        if(depth == 7){
            int sum = 0;
            //System.out.println(Arrays.toString(result));
            for(int n:result){
                sum+=n;
                if(sum > 100){
                    return;
                }
            }
            if(sum == 100){
                flag = true;
                //System.out.println(Arrays.toString(result));
                for(int n : result){
                    System.out.println(n);
                }
            }
            return;
        }

        for(int i=start; i<9; i++){
            if(!visited[i]){
                visited[i] = true;
                result[depth] = arr[i];
                dfs(depth+1,start+1);
                visited[i] = false;
            }
        }
    }
}

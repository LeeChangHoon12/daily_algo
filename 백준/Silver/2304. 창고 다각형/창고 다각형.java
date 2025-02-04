import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    static int[] arr;
    static int first;
    static int last;


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[1001];
        first = 1001;
        last = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            arr[x] = height;
            first = Math.min(first, x);
            last = Math.max(last, x);
        }

        Stack<Integer> heightStack = new Stack<>();

        int tmp = arr[first];
        for (int i = first + 1; i <= last; i++) {
            if(arr[i] < tmp)  {
                heightStack.push(i);
            }
            else {
                while (!heightStack.isEmpty()) {
                    arr[heightStack.pop()] = tmp;
                }
                tmp = arr[i];
            }
        }

        heightStack = new Stack<>();

        tmp = arr[last];
        for(int i=last-1;i>=first;i--){
            if(arr[i] < tmp) {
                heightStack.push(i);
            }
            else {
                while (!heightStack.isEmpty()) {
                    arr[heightStack.pop()] = tmp;
                }
                tmp = arr[i];
            }
        }

        int result = 0;

        for (int i=first;i<=last;i++) {
            result += arr[i];
        }

        System.out.println(result);
    }
}
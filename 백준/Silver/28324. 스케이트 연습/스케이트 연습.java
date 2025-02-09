import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N-1; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        arr[N-1] = 1;


        long result = 0;

        for(int i=N-1; i>=1; i--){
            if(arr[i] >= arr[i-1]){
                result += arr[i];
            }
            else{
                result += arr[i];
                arr[i-1] = arr[i]+1;
            }


        }

        System.out.println(result+arr[0]);

    }
}

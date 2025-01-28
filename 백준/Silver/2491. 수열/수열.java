import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int ascCount = 1;
    static int ascMax = 1;
    static int descCount = 1;
    static int descMax = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=0; i<N-1; i++){
            check(i);
        }
        System.out.println(Math.max(ascMax,descMax));
    }

    public static void check(int index){

        if(arr[index] < arr[index+1]){
            ascCount++;

            descMax = Math.max(descMax,descCount);
            ascMax = Math.max(ascMax,ascCount);

            descCount = 1;


        }else if(arr[index] > arr[index+1]){
            descCount++;

            ascMax = Math.max(ascMax,ascCount);
            descMax = Math.max(descMax,descCount);

            ascCount = 1;


        }else{

            ascCount++;
            descCount++;

            descMax = Math.max(descMax,descCount);
            ascMax = Math.max(ascMax,ascCount);

        }
    }
}

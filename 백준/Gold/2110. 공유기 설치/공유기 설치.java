import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main   {
    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];


        for(int i=0; i<N; i++){
            arr[i]= Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 1;
        int end = arr[N-1] - arr[0] +1;

        while(start + 1 < end){
            int mid = (start + end)/2;
            if(check(mid)){
                start = mid;
            }else{
                end = mid;
            }
        }

        System.out.println(start);

    }

    public static boolean check(int mid){
        int cnt = 1;
        int lastPos = arr[0];
        for(int i =1; i<arr.length; i++){
            int pos = arr[i];
            if(pos - lastPos >= mid){
                cnt++;
                lastPos = pos;
            }
        }


        return cnt >= M;
    }

}

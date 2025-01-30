
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws java.io.IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(br.readLine());
        for(int i=0; i<studentNum; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            //남학생
            if(s == 1){
                for(int index=1; index<=N; index++){
                    if(index % num == 0){

                        changeStatus(index);

                    }
                }
            //여학생
            }else{
                int left = num-1;
                int right = num+1;
                changeStatus(num);
                while(true){

                    if(left < 1 || right > N){
                        break;
                    }

                    if(arr[left] == arr[right]){
                        changeStatus(left);
                        changeStatus(right);


                        left--;
                        right++;
                    }else{
                        break;
                    }

                }



            }

        }

        for(int i=1; i<=N; i++){
            System.out.print(arr[i] + " ");
            if(i % 20 == 0){
                System.out.println();
            }
        }


    }

    public static void changeStatus(int index){
        if(arr[index] == 0){
            arr[index] = 1;
        }else{
            arr[index] = 0;
        }
    }
}

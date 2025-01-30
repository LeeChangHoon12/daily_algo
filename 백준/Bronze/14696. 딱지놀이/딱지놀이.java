import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        for(int k=0; k<K; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int turnA = Integer.parseInt(st.nextToken());
            int[] arrA = new int[5];
            for(int i=0; i<turnA; i++){
                arrA[Integer.parseInt(st.nextToken())]++;
            }

            st = new StringTokenizer(br.readLine());
            int turnB = Integer.parseInt(st.nextToken());
            int[] arrB = new int[5];
            for(int i=0; i<turnB; i++){
                arrB[Integer.parseInt(st.nextToken())]++;
            }

            for(int i=4; i>=1; i--){
                if(i == 4){
                    if(arrB[i] > arrA[i]){
                        System.out.println("B");
                        break;
                    }else if(arrB[i] < arrA[i]){
                        System.out.println("A");
                        break;
                    }else{
                        continue;
                    }
                }else if(i == 3){
                    if(arrB[i] > arrA[i]){
                        System.out.println("B");
                        break;
                    }else if(arrB[i] < arrA[i]){
                        System.out.println("A");
                        break;
                    }else{
                        continue;
                    }
                }else if(i == 2){
                    if(arrB[i] > arrA[i]){
                        System.out.println("B");
                        break;
                    }else if(arrB[i] < arrA[i]){
                        System.out.println("A");
                        break;
                    }else{
                        continue;
                    }
                }else if(i == 1){
                    if(arrB[i] > arrA[i]){
                        System.out.println("B");
                        break;
                    }else if(arrB[i] < arrA[i]){
                        System.out.println("A");
                        break;
                    }else{
                        System.out.println("D");
                        break;
                    }
                }
            }

        }


    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

   

    Integer[] arrK = new Integer[K];
    
    int need;
    //최소 필요 공 갯수
    if(K % 2 == 0) {
    	need = (K+1)*(K/2);
    }else {
    	need = (K+1)*(K/2) + (K/2+1);
    }
    

    
    if(need <= N) {
    	for(int i=0; i<K; i++){
            arrK[i] = i+1;
            N = N - (i+1);

        }
    }else {
    	System.out.println(-1);
    	return;
    }

//    
//    
//    
//    
//    for(int i=0; i<K;i++){
//        System.out.print(arrK[i] + " ");
//    }
//    System.out.println();
    

    while(true){
    	if((N - K) < 0) {
    		break;
    	}
        for(int i=0; i<K; i++){
            arrK[i]++;
        }
        N = N-K;
    }
//    
//    for(int i=0; i<K;i++){
//        System.out.print(arrK[i] + " ");
//    }
//    System.out.println();
//
//    System.out.println(N);
    arrK[(K-N)%K] += N;


    for(int i=0; i<K-1; i++){
        if(arrK[i] == arrK[i+1]){
            System.out.println(-1);
            return;
        }
    }

//    for(int i=0; i<K;i++){
//        System.out.print(arrK[i] + " ");
//    }
//    System.out.println();


    Arrays.sort(arrK);
    //System.out.println(N);


//
//    for(int i=0; i<K;i++){
//        System.out.print(arrK[i] + " ");
//    }
//    System.out.println();


    System.out.println(Math.abs(arrK[0] - arrK[K-1]));


}
}


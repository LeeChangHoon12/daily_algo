import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 순서열 A : < 혹은 > 로 k개가 나열
 * 부등호 앞 뒤에 숫자를 넣어서 모든 부등호 관계가 만족해야함.
 * ex) 3 < 4 < 5 < 6 > 1 < 2 < 8 > 7 < 9 > 0
 * 여기서 부등호를 제거하면, 부등호 관계를 만족하는 정수 = 3456128790
 * 위 만족하는 정수의 최대값과 최솟값 찾기
 *
 *
 * */
public class Main {
    static int K;
    static int length;
    static Long min;
    static int[] minArr;
    static Long max;
    static int[] maxArr;

    static char[] boodngs;
    static int[] targetNums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        length = K+1;

        boodngs = new char[K];
        targetNums = new int[length];
        visited = new boolean[10];

        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;

        maxArr = new int[K+1];
        minArr = new int[K+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            boodngs[i]= st.nextToken().charAt(0);
        }

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<maxArr.length; i++){
            sb.append(maxArr[i]);
        }
        sb.append("\n");
        for(int i=0; i<minArr.length; i++){
            sb.append(minArr[i]);
        }

        System.out.print(sb);
    }
    public static void dfs(int depth){

        if(depth == length){
            //부등호 만족 검사
            if(isValid(targetNums)){
                long nums = getNums(targetNums);
                //System.out.println(nums);
                if(nums > max ){
                    max = nums;
                    for(int i=0; i<targetNums.length; i++){
                        maxArr[i] = targetNums[i];
                    }
                }

                if(nums < min){
                    min = nums;
                    for(int i=0; i<targetNums.length; i++){
                        minArr[i] = targetNums[i];
                    }
                }

            }
            return;
        }

        for(int i=0; i<=9; i++){
            if(!visited[i]){
                visited[i] = true;
                targetNums[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

    public static boolean isValid(int[] targetNums){
        for(int i=0; i<K; i++){
            if(boodngs[i] == '<'){
                if(targetNums[i] < targetNums[i+1]){
                    continue;
                }else{
                    return false;
                }
            }else if(boodngs[i] == '>'){
                if(targetNums[i] > targetNums[i+1]){
                    continue;
                }else{
                    return false;
                }
            }
        }

        return true;
    }

    public static long getNums(int[] targetNums){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<targetNums.length; i++){
            sb.append(targetNums[i]);
        }


        return Long.parseLong(sb.toString());

    }

}

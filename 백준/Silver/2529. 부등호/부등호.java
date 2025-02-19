import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 메모리 : 23712kb	시간 : 452ms
 * 체감난이도 : 5/10
 * 
 * 어려웠던 점 : 배열 복사할 때, 자꾸 깊은 복사 얕은 복사 실수를 함. 그래도 예전에는 실수자체를 인지못했지만,
 *              이번에는 바로 확인하고, 배열 복사부터 확인해서 수정할 수 있었음.
 *               !!!! 1차 역량테스트 보충시간에 배웠던  System.arraycopy() 메소드를 사용해봄 !!!!!
 * 
 * 순서열 A : < 혹은 > 로 k개가 나열
 * 부등호 앞 뒤에 숫자를 넣어서 모든 부등호 관계가 만족해야함.
 * ex) 3 < 4 < 5 < 6 > 1 < 2 < 8 > 7 < 9 > 0
 * 여기서 부등호를 제거하면, 부등호 관계를 만족하는 정수 = 3456128790
 * 위 만족하는 정수의 최대값과 최솟값 찾기
 *
 * 아이디어 : 
 * 숫자의 갯수 = K+1개가 됨
 * K+1개 숫자로 만들 수 있는 순열을 모두 부등호에 대입해서 확인
 * 성공한 숫자로 최대값 최소값 갱신
 * 
 * 최대값과 출력을 위한 최대값을 만드는 숫자배열을 따로 관리함(맨 앞에 0이 들어가는 경우에 0도 출력해줘야하는데, 배열로 하면 맨앞에 0부터 출력할 수 있음)
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
                    System.arraycopy(targetNums, 0, maxArr, 0, targetNums.length);
                }

                if(nums < min){
                    min = nums;
                    System.arraycopy(targetNums, 0, minArr, 0, targetNums.length);
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

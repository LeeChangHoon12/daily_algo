import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/** 
 * 숫자 카드 = 정수 하나가 적혀있음.
 * 상근이는 N개의 숫자 카드
 * 정수 M개들 중, 상근이의 N개의 카드 중에서 포함되어 있으면 1, 없으면 0 출력
 * 
 * 1 <= N <= 500,000
 * -10,000,000 <= 숫자 <= 10,000,000
 * -10,000,000 <= M <= 10,000,000
 * 
 *  => 단순 탐색으로는 시간초과 발생 => 이분탐색을 통해서 탐색시간 최적화 필요
 * 
 * 
 * */

public class Main {
	static int N, M;
	static int[] arrN, arrM;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arrN = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		Arrays.sort(arrN);
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			System.out.print(biSearch(num)+ " ");
		}
	
	}
	
	public static int biSearch(int num) {
		
		int left = 0;
		int right = N-1;
		
		while(left <= right) {
			int middle = (left + right)/2;
			
			if(num > arrN[middle]) {
				left = middle+1;
			}else if(num < arrN[middle]) {
				right = middle-1;
			}else {
				return 1;
			}
		}
		return 0;
	}
}

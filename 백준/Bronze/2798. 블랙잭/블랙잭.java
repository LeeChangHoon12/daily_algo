import java.util.*;
import java.io.*;
/** 
 * 보드게임 M을 넘지않는 서에서 적힌 숫자들의 합 최대로
 * N개의 카드에서 3장의 합
 * */
public class Main {
	static int N, M;
	static int[] cards;
	static int[] arr;
	static boolean[] visited;
	static int sum;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cards = new int[N];
		visited = new boolean[N];
		arr = new int[3];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		search(0,0);
		
		System.out.println(max);
		
	}
	
	public static void search(int depth,int start) {

		if(depth == 3) {
			//System.out.println(Arrays.toString(arr));
			//max = Math.max(sum, max);
			int tmpSum = 0;
			for(int i=0; i<3; i++) {
				tmpSum += arr[i];
			}
			
			if(tmpSum <= M) {
				max = Math.max(tmpSum, max);
			}
			
			
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				arr[depth] =  cards[i];
				//sum += cards[i];
				visited[i] = true;
				search(depth+1,i+1);
				visited[i] = false;
			}
		}
		
	}
	

}

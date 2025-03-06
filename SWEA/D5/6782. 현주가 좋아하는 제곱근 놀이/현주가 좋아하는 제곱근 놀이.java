import java.util.*;
import java.io.*;

/** 
 * 2이상의 정수 N
 * 
 * N은 N+1로 바꾸거나
 * 루트N이 정수면 루트N으로 바꿀수 있음
 * 
 * N을 2로 만드는 최소 횟수 구하기
 * 
 * */

public class Solution {
	static double N;
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextDouble();
	
			sb.append("#" + tc + " " + makeTwo(N) + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static int makeTwo(double N) {
		int cnt = 0;
		
		while(N != 2) {
			
			if(Math.sqrt(N) - Math.floor(Math.sqrt(N)) == 0) {
				N = Math.sqrt(N);
				cnt++;
				
			}else {
				double root = Math.floor(Math.sqrt(N)) + 1;
				cnt += root * root - N + 1;
				N = root;
			}
			
		}
		
		return cnt;
	}
}

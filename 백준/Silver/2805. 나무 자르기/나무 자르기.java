
import java.util.*;
import java.io.*;

public class Main{
	static long N, M;
	static long[] trees;
	static long e,s,m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		trees = new long[(int) N];
		

		
		st = new StringTokenizer(br.readLine());
		for(int i =0 ; i< N; i++) {
			trees[i] = Long.parseLong(st.nextToken());			
		}
		
		Arrays.sort(trees);
		s = 0; // 절단기 높이 시작
		e = trees[(int) (N-1)]; // 절단기 높이 끝  
		
		
		while(s < e) {
			m = (s+e)/2;
			long sum = getTrees(m);
			 if(sum < M) {
				e = m;
			}else {
				s = m+1;
			}
		}
		
		System.out.println(s-1);
		
	}
	
	public static long getTrees(long h) {
		long result = 0;
		for(int i = 0; i < N; i++) {
			if(trees[i] - h > 0) {
				result += trees[i]-h;
			}
		}
		
		return result;
	}
}

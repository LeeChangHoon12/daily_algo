import java.io.*;
import java.util.*;
/** 
 * upper bound를 찾아보자 
 * */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		long[] arr = new long[N];
		
		long start =1; //시작 길이 
		long end = 0; //끝 길이
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			end = Math.max(end, arr[i]);
		}
		
		long len = (start+end)/2;
		
		
		while(start <= end) {
	
			int count = 0;
			for(int i=0; i<N; i++) {
				count += arr[i]/len;
			}
			

			if(count < K) { //부족하면 
				end = len-1; //왼쪽 범위 
			}else { //넘치면 
				start = len+1; //오른쪽 범위
			}

			len = (start+end)/2;
		}
		
		System.out.println(start-1);
		

		
	}
}

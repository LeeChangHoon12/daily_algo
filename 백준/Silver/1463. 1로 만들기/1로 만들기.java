

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		

		
		if(N == 1) {
			System.out.println(0);
			return;
		}

		if( N == 2 || N == 3  ) {
			System.out.println(1);
			return;
		}
		
		int[] b = new int[N+1];
		

		b[0] = 0;
		b[1] = 0;
		b[2] = 1;
		b[3] = 1;
		b[4] = 2;
		
		for(int i=5 ; i<=N; i++) {
			
			b[i] = b[i-1] + 1;
			
			if( i% 2 == 0) {
				b[i] = Math.min( (b[i]),(b[i/2] +1));
				
			}
			
			if( i% 3 == 0 ) {
				b[i] = Math.min( (b[i]),(b[i/3] +1));
			}

			
		}
		
		System.out.println(b[N]);
		
	}
}

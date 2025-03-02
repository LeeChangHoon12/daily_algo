
import java.util.*;
import java.io.*;

public class Main {
	static int result1;
	static int result2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.print(fin(N) + " ");
		
		int[] dp = new int[N+1];
		
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i = 3; i <= N; i++) {
			result2++;
			dp[i] = dp[i-1] + dp[i-2];
		} 
		
		System.out.print(result2);
		
	}
	
	static int fin(int n) {
		
		result1++;
		
		if(n ==1 || n == 2) {
			return 1;
		}
		
		return fin(n-1) + fin(n-2);
	}
	
	
}


import java.util.*;
import java.io.*;

public class Main {
	
	
	static int N;
	static int M;
	static int[] result;
	static boolean[] visited;

	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		dfs(0,0);
	}
	
	public static void dfs(int depth,int start) {
		if(depth == M) {
			for(int i=0; i<result.length; i++) {
				System.out.print(result[i]+ " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<N; i++) {
			result[depth] = i+1;
			dfs(depth+1,i+1);
		}
	}
}

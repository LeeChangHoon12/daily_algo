import java.util.*;
import java.io.*;


public class Main {
	
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			arr = new int[M];
			visit = new boolean[N];
			
			dfs(N,M,0);
			System.out.println(sb);	
	}
	


			
	
//	배열을 순회하면서 원하는 개수만큼 depth에 들어감
//	원하는 depth에 도달하면 출력?
	public static void dfs(int N, int M, int depth) {
		
		if(depth == M) {
			for(int var : arr) {
				sb.append(var + " ");
			}
			sb.append("\n");
			//출력
			return;
		}
		
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(N,M,depth+1);
				visit[i] = false;
			}
		}
		
	}
	
	

}

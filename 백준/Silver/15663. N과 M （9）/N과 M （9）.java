
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] result;
	static int[] arr;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];
		
		
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);

		dfs(0);
	}
	
	static void dfs(int depth){
        if(depth == M) {
        	for(int i=0; i<M; i++) {
        		System.out.print(result[i]+" ");
        	}
        	System.out.println();
        	return;
        }
        
        int before = 0;
        for(int i=0; i<N;i++) {
        	if(!visited[i] && before != arr[i]) {
        		result[depth] = arr[i];
        		before = arr[i];
        		visited[i]= true;
        		dfs(depth+1);
        		visited[i]= false;
        	}
        }
        
	}
}

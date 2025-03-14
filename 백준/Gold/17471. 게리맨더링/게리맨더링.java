import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static boolean[] visited;
	static int N;
	static List<ArrayList<Integer>> graph;
	static int population[];
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		N = Integer.parseInt(br.readLine());
		population = new int[N+1];
		graph = new ArrayList<>();
		visited = new boolean[N+1];
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}

		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int c=0; c<cnt; c++ ) {
				graph.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		gill(1);
		
		//System.out.println(min);
		
		if(min == Integer.MAX_VALUE){
			min = -1;
		}
		
		System.out.println(min);
		
	}
	
	public static void gill(int depth) {
		
		if(depth > N) {
			//System.out.println(Arrays.toString(visited));
			
			boolean flag = true;
			
			List<Integer> A = new ArrayList<>();
			boolean[] visitedA = new boolean[N+1];
			boolean[] isA = new boolean[N+1];
			
			List<Integer> B = new ArrayList<>();
			boolean[] visitedB = new boolean[N+1];
			boolean[] isB = new boolean[N+1];
			
			for(int i=1; i<=N; i++) {
				if(visited[i]) {
					A.add(i);
					isA[i] = true;
					
				}else {
					B.add(i);
					isB[i] = true;
				}
			}
			
			//System.out.println(A + " " + B);
			
			if(A.size() == 0 || B.size() == 0) {
				return;
			}
			
			visitedA[A.get(0)] = true;
			if(dfs(A.get(0), visitedA, 1, isA) != A.size()) {
				flag = false;
			}
			//System.out.println();
			
			visitedB[B.get(0)] = true;
			if(dfs(B.get(0), visitedB, 1, isB ) != B.size()) {
				flag = false;
			}
			//System.out.println(flag);
			//System.out.println();
			
			if(flag) {
				int sumA = 0;
				int sumB = 0;
				for(int i=1; i<=N;i++) {
					if(visited[i]) {
						sumA += population[i];
					}else {
						sumB += population[i];
					}
				}
				
				min = Integer.min(min, Math.abs(sumA-sumB));
			}
			
			return; 
		}
		
	
		visited[depth] = true;
		gill(depth+1);
		visited[depth] = false;
		gill(depth+1);
		
	}
	
	public static int dfs(int now, boolean[] visited, int cnt, boolean[] isT) {
		
		//System.out.print(now + " ");
		
		for(int n : graph.get(now)) {
			if(!visited[n] && isT[n]) {
				visited[n] = true;
				cnt = dfs(n, visited, cnt+1,isT);
			}
		}
		
		return cnt;

	}
}

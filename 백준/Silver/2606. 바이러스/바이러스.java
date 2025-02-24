
import java.io.*;
import java.util.*;
/** 
 * 1번 컴퓨터에서 시작해서
 * 바이러스가 몇대의 컴퓨터를 감염시키는지
 *
 *	넓이우선이나, 깊이 우선 둘다 가능할듯
 * */
public class Main {
	static int V;
	static int E;
	static boolean[] visited;
	static List<ArrayList<Integer>> graph;
	static int cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		
		for(int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(end);
			graph.get(end).add(start);
		}
		visited = new boolean[V+1];
		visited[1] = true;
		cnt = 0;
		dfs(1);
		System.out.println(cnt-1);
	}
	
	public static void dfs(int current) {
		cnt++;
		for(int next : graph.get(current)) {
			if(!visited[next]) {
				visited[next] = true;
				dfs(next);
			}
		}
	}
}

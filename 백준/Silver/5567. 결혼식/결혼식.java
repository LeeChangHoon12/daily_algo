
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static List<ArrayList<Integer>> graph = new ArrayList<>();
	static int N;
	static int M;
	
	static Queue<Node> q = new ArrayDeque<Node>();
	static boolean[] visited;
	
	static int result = 0;

	public static void main(String[] args) throws Exception {
		//--------------솔루션 코드를 작성하세요.--------------------------------
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			
			graph.get(to).add(from);
			graph.get(from).add(to);
		}
		
		visited[1] = true;
		q.offer(new Node(1,0));
		
		bfs();
		
		System.out.println(result);
		
	}
	
	public static void bfs() {
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			for(int to : graph.get(now.from)) {
				if(!visited[to]) {
					visited[to] = true;
					q.offer(new Node(to, now.cnt+1));
					if(now.cnt+1 == 1 || now.cnt+1 == 2) {
						result++;
					}
				}
			}
		}
	}
	

	
	static class Node{
		int from;
		int cnt;
		
		public Node(int from, int cnt) {
			this.from = from;
			this.cnt = cnt;
		}
	}

}

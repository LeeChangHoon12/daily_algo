import java.io.*;
import java.util.*;

public class  Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int start;
	static List<ArrayList<Integer>> graph;
	static int[] visited;
	static Queue<Node> q = new ArrayDeque<>();
	static int max = 0;
	static int maxDepth = 1;

	public static void main(String[] args) throws Exception {
		
		for(int t=1; t<=10; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			visited = new int[101];			
			for(int i=0; i<= 100; i++) {
				graph.add(new ArrayList<>());
			}
			
			
			
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				//System.out.println(from + " " + to);
				graph.get(from).add(to);
			}
			
			
		
			
			visited[start] = 1;
			q.offer(new Node(start, 1));
			maxDepth = 1;

			
			while(!q.isEmpty()) {
				
				Node now = q.poll();

				
				for(int to : graph.get(now.from)) {
					if(visited[to] == 0) {
						visited[to] = now.depth+1;
						maxDepth = Math.max(visited[to], maxDepth);
						q.add(new Node(to, now.depth+1 ));
					}					
				}		
				
			}
			
			for(int i=100; i>=0; i--) {
				if(visited[i] == maxDepth) {
					System.out.println("#" +t + " " +  i);
					break;
				}
			}
			
			
			
			
			

		}
	}
	
	public static void input() {
		
	}
	
	static class Node{
		int from;
		int depth;
		
		public Node(int from, int depth) {
			this.from = from;
			this.depth = depth;
		}
	}

}

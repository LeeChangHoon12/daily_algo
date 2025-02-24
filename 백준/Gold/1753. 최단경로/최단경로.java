import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V;
	static int E;
	static int start;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine());
		
		List<ArrayList<Node>> graph = new ArrayList<>();
		// u v w( u에서 v로 가는 비용 w)
		for(int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < E; i++)	{
			st = new StringTokenizer(br.readLine());
			//노드 u는
			int u = Integer.parseInt(st.nextToken());
			//v 로 간다
			int v = Integer.parseInt(st.nextToken());
			// 비용 w가 든다
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v,w));
		}
		
		int[] d = new int[V + 1]; // index 1부터 사용하기 위해서 
		Arrays.fill(d, Integer.MAX_VALUE);
		d[start] = 0;
		
		//가중치가 작은 노드부터 탐색하기 위해서 우선순위 큐를 사용함
		PriorityQueue<Node> pq = new PriorityQueue<>();
		//시작 노드 설정 
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			
			//이미 처리된 노드라면 건너뜀.
			//이미 최단거리가 되있으면, 볼 필요가 없다.
			if(d[current.v] < current.w) {
				continue;
			}
			
			//현재 접점과 연결된 모든 노드들에 대해서 최단 거리를 갱신
			for(Node next : graph.get(current.v)) {
				//연결된 다음 노드 번호와 비용
				int nextV  = next.v;
				int nextW = next.w + current.w;
				
				//노드 이동 비용이 기존에 갱신했던 비용보가 작다면
				if(nextW < d[nextV]) {
					d[nextV] = nextW; //갱신하고 
					pq.offer(new Node(nextV, nextW)); //우선순위 큐에 넣는다.
				}
				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(d[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			}
			else {
				sb.append(d[i] + "\n");
			}
		}
		
		System.out.println(sb);
		
	}
	
	static class Node implements Comparable<Node>{
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		//간선 비용이 적은 순서대로 정렬하기 위해서 compareTo 오버라이드
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			
			return Integer.compare(this.w, o.w);
		}
	}
}



import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		List<Node> arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr.add(new Node(start, end));
		}
		
		Collections.sort(arr);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		pq.add(arr.get(0).end);
		
	
		for(int i=1; i<N; i++) {
			if(pq.peek() <= arr.get(i).start) {
				pq.poll();
			}
			pq.add(arr.get(i).end);
			
		}
		
		System.out.println(pq.size());
		
		
	}
	static class Node implements Comparable<Node>{
		int start;
		int end;
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Node o) {
			
			if(this.start == o.start) {
				return Integer.compare(this.end, o.end);
			}else {
				return Integer.compare(this.start, o.start);
			}
			 
		}
	}
}

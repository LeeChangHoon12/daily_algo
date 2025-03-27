import java.io.*;
import java.util.*;


public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
			
	static int parents[];
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}



		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}		
	}
	static int V,E;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			input();
			
			int count = 0;
			long result = 0;
			for(Edge e : edgeList) {
				if(union(e.from, e.to)) {
					result += e.weight;
					count++;
					
					if(count == V-1) {
						break;
					}
				}
			}
			
			System.out.println("#"+t + " " + result);
			
		}
	}
	
	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V+1];
		
		for(int i=0; i<=V; i++) {
			parents[i] = i;
		}
		
		
		edgeList = new Edge[E];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight= Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edgeList);
		
	}
	
	public static int find(int n) {
		if(parents[n] == n) return n;
		return parents[n] = find(parents[n]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[aRoot] = bRoot;
		return true;
	}
	
}

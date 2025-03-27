import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int V;
	static double E;

	static int[] x;
	static int[] y;
	
	static int[] parents;
	
	static List<Edge> edgelist;
	static double result;
	static int count;

	static class Edge implements Comparable<Edge> {
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}

	}
	
	static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			input();
			result =  0;
			count = 0;
			for(Edge e : edgelist) {
				if(union(e.from, e.to)) {
					result += e.weight;
					count++;
					if(count == V-1) {
						break;
					}
				}
			}
			
			System.out.println("#" + t + " " + Math.round(result));
			
		}
	}

	public static void input() throws Exception {
		V = Integer.parseInt(br.readLine());

		x = new int[V];
		y = new int[V];

		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < V; j++) {
			x[j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < V; j++) {
			y[j] = Integer.parseInt(st.nextToken());
		}
		
		E = Double.parseDouble(br.readLine());
		
		edgelist = new ArrayList<>();
		
		parents = new int[V];
		
		
		for(int i=0; i<V; i++) {
			
			parents[i] = i;
			
			for(int j=0; j<V; j++) {
				
				if(i == j) continue;
				
				double cost = (Math.pow(x[i]-x[j], 2) + Math.pow(y[i]-y[j], 2)) * E;
				edgelist.add(new Edge(i, j, cost));
				
			}
		}
		
		Collections.sort(edgelist);
	}
	
	
	public static int find(int n) {
		if(n == parents[n]) return n;
		return find(parents[n]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		if(aRoot > bRoot) parents[bRoot] = aRoot;
		else parents[aRoot] = bRoot;
		
		return true;
	}
}

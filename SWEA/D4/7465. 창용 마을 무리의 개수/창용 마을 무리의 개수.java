
import java.io.*;
import java.util.*;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[] parents;
	static int n,m;
	static int count;
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			input();
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			
			for(int i=1; i<=n; i++) {
				if(i == parents[i]) {
					count++;
				}
			}
			
			System.out.println("#"+t+" "+count);
		}
	}
	
	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		count = 0;
		parents = new int[n+1];
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
	}
	
	public static void union(int a, int b) {
		int aRoot = findRoot(a);
		int bRoot = findRoot(b);
		
		if(aRoot == bRoot) {
			return;
		}
		
		parents[bRoot] = aRoot;
		
	}
	
	public static int findRoot(int num) {
		
		if(num == parents[num]) {
			return num;
		}
		
		return findRoot(parents[num]);
	}
	
}

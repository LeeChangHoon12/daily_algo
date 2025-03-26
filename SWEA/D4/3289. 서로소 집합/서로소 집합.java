
import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n;
	static int m;

	static int[] parents;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			input();

			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int com = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (com == 0) {
					union(a, b);
				} else {
					if (find(a) == find(b)) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				}
			}
			
			System.out.println(sb.toString());

		}
	}

	public static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 초기화
		parents = new int[n+1];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

	}

	//집합 합치기 
	public static void union(int a, int b) {

		
		int aRoot = find(a);//a의 루트 
		int bRoot = find(b);//b의 루트 

		if (aRoot == bRoot) {
			return;
		}

		parents[bRoot] = aRoot;

	}

	//root 찾기 
	public static int find(int a) {
		if (parents[a] == a) //a의 루트가 본인이라면 -> 끝에 도달함 -> 리턴 
			return a;
		return parents[a] = find(parents[a]); //지금 상태에서 a의 부모가 누구인지를 확인함 //확인하면서 경로 압축 
	}
}

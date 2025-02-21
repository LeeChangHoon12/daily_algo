import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 
 * 
 * 사용할 수 있는 재료 1~N
 * 가능한 많은 종류의 버거를 만들고 싶다.
 * 하지만 어울리지 않는 재료가 같이 들어가면 안된다.
 * 
 * 목표 : M개에 대한 어울리지 않는 재료 쌍이 주어졌을 떄, 1~N의 재료로 만들 수 있는 요리 가지 수
 * 주의 : 정확하게 같은 종류의 재료를 사용하면, 같은 종류의 버거임
 * 
 * 힌트를 확인하면, 공집합도 포함해야함.
 * 
 * 1 <= N <= 20
 * 0 <= M <= 400
 * 
 * 아이디어 : 
 * 1~N 까지 재료를 사용하는 모든 부분집합을 확인
 * 모든 경우를 다음 경우를 보면서, 지금 들어가있는 곳에 재료쌍이 있는지 확인해봄
 * 
 * */
public class Solution {
	static int T;
	static int N;
	static int M;
	static int cnt;
	static ArrayList<Integer> items; // 
	static ArrayList<Integer> pairs;
	static boolean[][] itemsInfo;
	
	
	static int[] nums;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		

		
		
		for(int tc=1; tc<=T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			itemsInfo = new boolean[N+1][N+1];
			nums = new int[N+1];
			cnt = 0;
			for(int i=0; i< M; i++) {
				
				//어울리지 않는 재료 쌍
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				itemsInfo[a][b] = true;
				itemsInfo[b][a] = true;

			}

			
			search(1,nums);
			
			System.out.println("#" + tc + " " + cnt);
			
		}
		
		
	}
	
	public static void search(int depth, int[] nums) {

		if(depth == N+1) {
			//System.out.println(Arrays.toString(nums));
			for(int i=0; i<N; i++) {
				if(isExistPair(nums[i],nums)) {
					return;
				}				
			}
			
			cnt++;
			
			return;
		}
		
		
		int[] tmp1 = new int[N+1];
		for(int i=0; i<=N;i++) {
			tmp1[i] = nums[i];
		}
		
		search(depth+1, tmp1);
		
		int[] tmp2 = new int[N+1];
		for(int i=0; i<=N; i++) {
			tmp2[i] = nums[i];
		}
		tmp2[depth] = depth;
		search(depth+1, tmp2);

		
		
	}
	
	public static boolean isExistPair(int n, int[] nums) {
		
		boolean[] paired = itemsInfo[n];
		
		for(int i=0; i<nums.length;i++) {
			if(paired[nums[i]]) {
				return true;
			}
		}
		
		return false;
	}
}

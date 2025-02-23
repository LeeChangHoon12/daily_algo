import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 
 * n개의 재료
 * 신맛s
 * 쓴맛b
 * 
 * 신맛 = 신맛들의 곱
 * 쓴맛 = 쓴맛들의 합
 * 
 * 신맛과 쓴맛들의 차이를 적게함
 * 적어도 하나는 사용해야함.
 * 쓴맛과 신맛이 가장 적은 것
 * 
 * 아이디어 : 인덱스 조합을 만듬
 * 그 조합으로 쓴맛, 조합 만들어서 차의 최소 값을 구하기
 * 
 * */
public class Main {
	static int[] sin;
	static int[] ssn;
	
	static int sinScore;
	static int ssnScore;
	static int min = Integer.MAX_VALUE;
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		sin = new int[N];
		ssn = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sin[i] = Integer.parseInt(st.nextToken());
			ssn[i] = Integer.parseInt(st.nextToken());
		}
		
		//System.out.println(Arrays.toString(sin));
		//System.out.println(Arrays.toString(ssn));
		combination(0,1,0,0);
		System.out.println(min);
		
	}
	
	public static void combination(int depth, int sinScore, int ssnScore,int cnt) {
		
		if(depth == N) {
			if(cnt >= 1) {
				//System.out.println(sinScore + " " + ssnScore);
				min = Math.min(min, Math.abs(sinScore - ssnScore));
				return;
			}
			
			return;
		}
		
		//이번꺼 넣는 경우
		combination(depth+1, sinScore * sin[depth], ssnScore + ssn[depth] ,cnt+1);
		
		//이번꺼 안넣는 경우
		combination(depth+1, sinScore, ssnScore, cnt);
		
	}

}

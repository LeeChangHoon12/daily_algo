import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int N;
	static int M;
	static int[] cntPlus = new int[10000001];
	static int[] cntMinus = new int[10000001];;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++) {
			int target = Integer.parseInt(st.nextToken());
			if(target >= 0) {
				cntPlus[target]++;
			}else {
				cntMinus[target*-1]++;
			}
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int target = Integer.parseInt(st.nextToken());
			if(target >= 0) {
				System.out.print(cntPlus[target] + " ");
			}else {
				System.out.print(cntMinus[target*-1] + " ");
			}
		}
		
	}

}

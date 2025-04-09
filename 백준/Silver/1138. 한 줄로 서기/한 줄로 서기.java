import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		boolean[] checked = new boolean[N];
		int[] result = new int[N];
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//키가 1인 사람부터 
		for(int i=1; i<=N; i++) {
			// 자리 확인해서
			int cnt = -1;
			for(int j=0; j<N; j++) {
				if(!checked[j]) cnt++ ;
				if(cnt >= arr[i]) {
					result[j] = i;
					checked[j] = true;
					break;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(result[i] + " ");
		}
		
	}

	
}


//키가 1인 사람보다 큰 사람 2명있다  ->  1 왼쪽에 2명
//키가 2인 사람보다 큰사람 1명 - > 2왼쪽에 1명
//키가 3인 사람보다 큰 사람 1명  -> 3왼쪽에 1명
//키가 4인사람보다 큰 사람 없음 -> 4 왼족에 0명 

//0   1 2 3 4
//f   f f t f
  //2 1 
//arr[1] = 키 1인사람 왼쪽에 몇명 있는지
//
  
     //같거나 크고 f다 넣어

    
    // 인덱스 0부터 봐서 
    // 그 인덱스에 사람이 없고 
    // 왼쪽에 자기 사람만큼 올수 잇다 바로 넣어
    
    
    
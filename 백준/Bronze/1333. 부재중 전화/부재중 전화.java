import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/** 
 * 문제 : 
 * 노래 N곡
 * 노래의 길이는 전부 L
 * 노래와 노래 사이의 간격 5초
 * 첫곡을 듣는 순간은 0초 -> 전화벨이 울리기 시작함
 * 벨은 D초에 1번씩 울리고 1초 동안 울림
 * 
 * 노래 재생 중 / 전화벨과 노래가 같이 끝나는 경우 => 전화를 받을 수 없음.
 * 모든 앨범 수록 곡이 끝나면 전화받을 수 있음.
 * 
 * 출력 : 
 * 전화를 받을 수 있는 가장 빠른 시간
 * 
 * 입력 : 
 * N (1 <= N <= 20)
 * L (1 <= L <= 180)
 * D (1 <= D <= 20)
 * 
 * 1. 노래 재생 상태 배열 
 * 2. 노래 길이를 동적으로 추가해주기 위해서 arraylist 사용 (0은 전화못받음-노래 재생 중, 1은 전화받을 수 있음)
 * 3. d 만큼 인덱스를 접근하면서 1이면 전화 받을 수 있음 
 * 4. 마지막에 d를 더했는데, length를 넘어가면, 그 순간이 모든 앨범 종료 후 전화받는 상태
 * 

 * 
 * */

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		

		ArrayList<Integer> arr = new ArrayList<>();

		for(int i=0; i<N; i++) {
			for(int l=0; l<L; l++) {
				arr.add(0);
			}
			for(int j=0; j<5; j++) {
				arr.add(1);
			}
		}
		
		
		
		int index = 0;

		while(true) {
			if(index >= arr.size()) {
				break;
			}
			else if(arr.get(index) == 1) {
				break;
			}else {
				index += D;
			}
		}
		System.out.println(index);

	}

}

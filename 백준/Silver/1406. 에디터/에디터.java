import java.io.*;
import java.util.*;

/* 
 * 영어 소문자만 사용
 * 60,000글자까지 입력
 * '커서'
 * 첫번째 문자의 왼쪽,
 * 마지막 문장의 오른쪽
 * 중간
 * 
 * 0 0 0 0
 * */
public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Character> left = new ArrayDeque<Character>();
		Deque<Character> right = new ArrayDeque<Character>();

		String text = br.readLine();
		for (int i = 0; i < text.length(); i++) {
			left.push(text.charAt(i));
		}

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
			case "L":
				if(!left.isEmpty()) {
					right.push(left.pop());
				}
				
				break;
			case "D":
				if(!right.isEmpty()) {
					left.push(right.pop());
				}				
				break;
			case "B":
				if(!left.isEmpty()) {
					left.pop();
				}
				break;
			case "P":
				String newText = st.nextToken();
				left.push(newText.charAt(0));
				break;

			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!left.isEmpty()) {
			sb.append(left.pollLast());
		}
		
		while(!right.isEmpty()) {
			sb.append(right.pollFirst());
		}
		
		System.out.println(sb);

	}

}

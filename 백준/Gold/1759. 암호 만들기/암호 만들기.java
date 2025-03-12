
import java.io.*;
import java.util.*;

/**
 * 모음 최소 한개
 * 자음 최소 2개
 * 
 * 사전식으로 정렬됨
 * abc - > 가능성 o
 * bac -> 가능성 x (사전식x)
 * 
 * c개의 문자를 가지고 만들 수 있는 가능
 *  
 **/
public class Main {
	
	static int L;
	static int C;
	static char[] password;
	static char[] chars;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		password = new char[L];
		chars = new char[C];
		visited = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<C; i++) {
			chars[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(chars);
		
		com(0,0);
		System.out.println(sb);
	}
	
	public static void com(int depth, int start) {
		if(depth == L) {
			
			int mo = 0;
			int ja = 0;
			
			for(int i=0; i<L; i++) {
				if(password[i] == 'a' || password[i] == 'e'|| password[i] == 'i' ||password[i] == 'o' || password[i] == 'u') {
					mo ++;
				}else {
					ja ++;
				}
			}
			
			if(mo >=1 && ja >= 2) {
				for(int i=0; i<L; i++) {
					sb.append(password[i]);
				}
				sb.append("\n");
			}
			
			return;
		}
		
		for(int i=start; i<C; i++) {
			password[depth] = chars[i];
			com(depth+1, i+1);
		}

		

	}
	
}

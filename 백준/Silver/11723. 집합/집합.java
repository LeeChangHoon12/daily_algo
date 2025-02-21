import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int S = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String fun = st.nextToken();
			int x= 0;
			
			
			if(st.hasMoreTokens()) {
				x = Integer.parseInt(st.nextToken());
			}
			
			
			if(fun.equals("add")) {
				add(x);
			}else if(fun.equals("remove")) {
				remove(x);
			}else if(fun.equals("check")) {
				check(x);
			}else if(fun.equals("toggle")) {
				toggle(x);
			}else if(fun.equals("all")) {
				all();
			}else if(fun.equals("empty")) {
				empty();
			}
			
		}
		
		System.out.println(sb);
		
	}

	public static void add(int x) {
		S = (S|(1<<x-1));
	}
	
	public static void remove(int x) {
		S =  (S & ~(1<<x-1));
	}
	
	public static void check(int x) {
		int result = S & (1<<x-1); 
		if( result != 0) {
			sb.append(1 + "\n");
		}else {
			sb.append(0 + "\n");
		}
	}
	
	public static void toggle(int x) {
		int result = S & (1<<x-1); 
		if( result != 0) {
			remove(x);
		}else {
			add(x);
		}
	}
	
	public static void all() {
		S = Integer.MAX_VALUE;
	}
	
	public static void empty() {
		S = 0;
	}
	
}

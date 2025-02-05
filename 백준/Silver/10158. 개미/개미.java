
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int time = Integer.parseInt(br.readLine());
		
		

		
		
		int resultC  = w-Math.abs(w - (c+time)%(2*w));
		int resultR = h-Math.abs(h - (r+time)%(2*h));
		
		System.out.println(resultC + " " + resultR);
		

	}

}

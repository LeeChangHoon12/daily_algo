import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		
		double[] numArr = new double[N];
		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
		
		Deque<Double> q = new ArrayDeque<>();
		
		double result = 0;
		for(int i=0; i<line.length(); i++){
			char c = line.charAt(i);
			
			if(c >= 'A' && c <= 'Z') {
				q.push(numArr[c - 'A']);
			}else {
				if(!q.isEmpty()) {
					
					double n = q.pop();
					double m = q.pop();
					
					switch(c) {
					case '/':
						result = m/n;
						break;
					case '*':
						result = m *n;
						break;
					case '+':
						result = m + n;
						break;
					case '-':
						result = m - n;
						break;
					}
					
					q.push(result);
				}
			}
		}
		
		System.out.printf("%.2f",q.pop());
		
		
	}
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int size;
	static int[] arr;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		
		arr = new int[size];
		result = new int[size];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0; i<size; i++) {
			int index = arr[i];
			push(index);
			result[index] = i+1;
		}
		
		for(int i=size-1; i>=0; i--) {
			System.out.print(result[i] + " ");
		}
				
	}
	
	//들어갈 인덱스 뒤로 한칸씩 밀기 
	public static void push(int index) {
		for(int i=size-1; i>index; i--) {
			result[i] = result[i-1];
		}
	}
}

import java.io.*;
import java.util.*;

public class Main{
	
	static int[] arr;
	static int[] numArr;
	static int first;
	static boolean[] visited;
	static boolean flag;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		first = Integer.parseInt(line);
		
		
		numArr = new int[line.length()];
		arr = new int[line.length()];
		visited = new boolean[line.length()];
		
		for(int i=0; i<line.length();i++) {
			numArr[i] = Integer.parseInt(line.charAt(i)+"");
		}
		
		
		search(0);
		if(!flag) {
			System.out.print(0);
		}else {
			System.out.print(min);
		}
		
	}
	
	public static void search(int depth) {
		

		
		if(depth == numArr.length) {
			//System.out.println(Arrays.toString(arr));
			String tmp = "";
			for(int n : arr) {
				tmp = tmp + n;
			}
			if(Integer.parseInt(tmp) > first) {
				
				
				min = Integer.min(min,Integer.parseInt(tmp) );
				
				flag = true;
			}
			return;
		}
		
		for(int i=0; i<numArr.length; i++) {
			if(!visited[i]) {
				arr[depth] = numArr[i];
				visited[i] = true;
				search(depth+1);
				visited[i] = false;
			}
		}
	}
}

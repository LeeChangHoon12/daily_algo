import java.util.*;
import java.io.*;

public class Main{
	
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			if(this.end == o.end) {
				return Integer.compare(this.start, o.start);
			}else {
				return Integer.compare(this.end, o.end);
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				
		int N = Integer.parseInt(br.readLine());
		
		Meeting[] meetings = new Meeting[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(start, end);
		}
		
		Arrays.sort(meetings);
		List<Meeting> result = new ArrayList<>();
		result.add(meetings[0]);
		
		for(int i = 1; i < N; i++) {
			if(result.get(result.size()-1).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
		}
		
		System.out.println(result.size());
		
		
	}
}

import java.util.*;
import java.io.*;

// N*N 판에 N개의 퀸을 양립하도록 놓기
public class Main {
	
	static int N,ans;
	static ArrayList<Integer> result;
	static boolean[] col, slash, bslash; //같은 열, 대각선 /(합이 일정함)  \(차가 일정함)
	
	
	//어차피 다른 행에 둘건데, 2차원에 둘 필요가 있어?
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new boolean[N+1];
		slash = new boolean[2*N+1];
		bslash = new boolean[2*N];
		
		result = new ArrayList<>();
		
		ans = 0;
		
		setQueens(1);
		
		System.out.println(ans);
		
		
	}
	
	//  대각선 \: 행 증가,열 증가 
	//  대각선 /: 행 증가,열 감소
	//  두점의 행 차이, 열 차이가 같으면 대각선임 = 절대값으로하면 두가지 대각선 경우
	static void setQueens(int row) {
		
		if(row > N) {
			ans++;
			return;
		}
		
		
		for(int c = 1; c <= N; c++) {
			//가지치기
			if(!isAvailable(row,c)) {
				continue;
			}
			
			col[c] = slash[row + c] = bslash[(row-c) + N] = true;
			setQueens(row+1);
			col[c] = slash[row + c] = bslash[(row-c) + N] = false;
			
		}
	}
	
	static boolean isAvailable(int row,int c) {
		return !col[c] && !slash[row+c] && !bslash[row-c+N];
	}
}

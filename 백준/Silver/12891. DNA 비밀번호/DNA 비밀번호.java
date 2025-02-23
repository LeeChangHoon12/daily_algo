import java.io.*;
import java.util.*;

/** 
 * 주어진 문자열(길이S)에서 조건을 만족해서 만들 수 있는 DNA비밀번호의 개수
 * 조건 : 
 * 	길이가 P가 되어야하고
 * 	A C  G T가 주어진 최소 개수 만큼 등장해야한다.
 * 
 * 아이디어 : '모든 조합을 만들어서 해결해보자' 라고 처음에 생각했는데,
 * 슬라이딩 윈도우를 사용하면 O(S) 번만에 검사할 수 있다.
 * 
 * */
public class Main {
    static int S, P, count;
    static int[] minCount = new int[4];  // A, C, G, T 최소 개수 조건
    static int[] currentCount = new int[4]; // 현재 슬라이딩 윈도우에서의 개수
    static char[] dna;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        dna = br.readLine().toCharArray();
       //System.out.println(dna);
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minCount[i] = Integer.parseInt(st.nextToken());
        }

        // 시작 할때, P개로된 윈도우 시작하기 떄문에, cnt 더해줌
        for (int i = 0; i < P; i++) {
            addChar(dna[i]);
        }

        // 첫 번째 윈도우가 유효한지 검사
        if (isValid()) count++;

        
        // 슬라이딩 윈도우 수행
        //P-1 인덱스까지, 처음 윈도우에서 수행했기 때문에
        //인데스 P 부터, 맨 왼쪽 뺴고, 맨 오른쪽을 추가하는 형식으로 진행
        // 추가하면 
        for (int i = P; i < S; i++) {
            addChar(dna[i]);           // 새로운 문자 추가
            removeChar(dna[i - P]);    // 윈도우에서 벗어난 문자 제거
            
            if (isValid()) count++;    // 유효한 비밀번호인지 검사
        }

        System.out.println(count);
    }

    // 현재 슬라이드에서 추가된 문자 카운트 +1
    private static void addChar(char c) {
        switch (c) {
            case 'A': 
            	currentCount[0]++; 
            	break;
            case 'C': 
            	currentCount[1]++; 
            	break;
            case 'G': 
            	currentCount[2]++; 
            	break;
            case 'T': 
            	currentCount[3]++; 
            	break;
        }
    }

    // 현재 슬라이드로 넘어오면서, 이전에 맨 왼쪽에서 사용됬던 문자 카운트 -1
    private static void removeChar(char c) {
        switch (c) {
            case 'A': 
            	currentCount[0]--; 
            	break;
            case 'C': 
            	currentCount[1]--; 
            	break;
            case 'G': 
            	currentCount[2]--; 
            	break;
            case 'T': 
            	currentCount[3]--; 
            	break;
        }
    }

    // 현재 슬라이딩 윈도우가 조건을 만족하는지 확인하는 함수
    private static boolean isValid() {
        for (int i = 0; i < 4; i++) {
            if (currentCount[i] < minCount[i]) {
                return false;
            }
        }
        return true;
    }
}
import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n > 0){
            if(n % 2 == 0){
                n/=2;
            }else{
                n--;
                answer++;
            }
        }
        
        return answer;
    }
}

//온거리 x2에 해당 하는 위치로 이동
// 순간이동은 건전지 사용 x
// k칸 점프하면 그만 큼 건ㅈ너지 사용
// N
import java.util.*;
class Solution {
    public Long[] solution(long n) {
        ArrayList<Long> arr = new ArrayList<>();
        
        while(n > 0){
            arr.add(n%10);
            n/=10;
        }
        
        Long[] answer = new Long[arr.size()];
        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);        
        }
            
    
        
        return answer;
    }
}
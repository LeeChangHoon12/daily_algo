import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] arr = new int[progresses.length];
        
        for(int i=0; i<progresses.length; i++){
            int lastDay = 100 - progresses[i];
            int baepoDay = 0;
            
            if(lastDay%speeds[i] != 0){
                baepoDay = lastDay/speeds[i] + 1;    
            }else{
                baepoDay = lastDay/speeds[i];
            }
            
            arr[i] = baepoDay;
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int cnt = 1;
        int current = arr[0];
        for(int i=0; i<arr.length-1; i++){
            if(current < arr[i+1]){
                result.add(cnt);
                cnt = 1;
                current = arr[i+1];
            }else{
                cnt++;
            }            
        }
        
        result.add(cnt);

        
        int[] answer = new int[result.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = result.get(i);
        }      
        
        return answer;
    }
}
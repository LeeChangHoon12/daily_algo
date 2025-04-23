import java.util.*;

public class Solution {
    public int[] solution(int []arr) {


        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(arr[0]);
        
        for(int i=1; i<arr.length; i++){
            if(dq.peekLast() != arr[i]){
                dq.add(arr[i]);
            }
        }
        
        int[] answer = new int[dq.size()];
        
        int i=0;
        for(int num : dq){
            answer[i++] = num;
        }
       
        return answer;
    }
}
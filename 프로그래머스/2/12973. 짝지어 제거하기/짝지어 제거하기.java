import java.util.*;

class Solution
{
    public int solution(String s) {
        
        Deque<Character> stack = new ArrayDeque<>();
        
        stack.push(s.charAt(0));
        
 
        
        for(int i=1; i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
               continue; 
            }
            if(stack.peek() == s.charAt(i)){
                    stack.pop();
             }else{
                    stack.push(s.charAt(i));
            }    
            
            
        }
        
        int answer = 0;
        
        if(stack.size() == 0) {
            answer = 1;
        }
        
        return answer;
    }
}
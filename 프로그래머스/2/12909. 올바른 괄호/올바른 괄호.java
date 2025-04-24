import java.util.*;

class Solution {
    boolean solution(String s) {
        
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.addLast(s.charAt(i));
            } else{
                if(!stack.isEmpty()){
                    stack.pollLast();
                }else{
                    return false;    
                }
                
            }
            
        }        
        
        if(stack.size() == 0){
            return true;
        }else{
            return false;
        }

    }
}
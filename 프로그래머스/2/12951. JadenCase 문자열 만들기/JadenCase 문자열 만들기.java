import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        s = s.toLowerCase();
       
        sb.append( s.substring(0,1).toUpperCase());
        
        for(int i=1; i<s.length(); i++){
            char c = s.charAt(i);
            if(s.charAt(i-1) == ' '){
                sb.append(Character.toUpperCase(c));
            } else{
                sb.append(c);
            }
            
        }

        
        return sb.toString();

    }
}
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] result = new int[2];

        
        char target = words[0].charAt(words[0].length()-1);
        boolean check = false;
        
        HashMap<String,Integer> hash = new HashMap<String,Integer>();
        hash.put(words[0],0);
        
        for(int i=1; i<words.length; i++){
            
            
            if(hash.containsKey(words[i])) {
                result[0] = (i%n)+1;
                result[1] = (i/n)+1;
                return result;
            }
            
            if(words[i].charAt(0) != target){
                result[0] = (i%n)+1;
                result[1] = (i/n)+1;
                return result;
            }
            
            hash.put(words[i],1);
            target = words[i].charAt(words[i].length()-1);
        }
        
        
        


        
        return result;
        
    }
}
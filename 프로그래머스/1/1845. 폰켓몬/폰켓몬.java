import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer,Integer> hash = new HashMap<>();
        
        int max = nums.length/2;
        
        for(int num : nums){
            if(hash.containsKey(num)){
                hash.put(num, hash.get(num)+1);
            }else{
                hash.put(num,1);
            }
        }
        
        int cnt = hash.keySet().size();
        
        answer = Math.min(cnt,max);
        
        return answer;
    }
}
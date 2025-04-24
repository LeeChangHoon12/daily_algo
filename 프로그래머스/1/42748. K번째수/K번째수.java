import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] result = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int target = commands[i][2]-1;
            
            int length = end - start + 1;
            
            ArrayList<Integer> newArr = new ArrayList<>();
            for(int j=start; j<=end; j++ ){
                newArr.add(array[j]);
            }
            
            Collections.sort(newArr);
            result[i] = newArr.get(target);
            
        }
        
        return result;
    }
}
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        HashMap<Integer,Integer> hash = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++){
            if(hash.containsKey(tangerine[i])){
                hash.put(tangerine[i], hash.get(tangerine[i])+1);
            }else{
                hash.put(tangerine[i], 1);
            }
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(Integer key : hash.keySet()){
            arr.add(hash.get(key));
        }
        
        Collections.sort(arr);
        Collections.reverse(arr);
        
        //System.out.print(arr);
        
        int count = 0;
        int sum = 0;

        for(int i=0; i<arr.size(); i++){
            sum += arr.get(i);
            count++;
            
            if(sum >= k){
                break;
            }
            
        }
        
        return count;
    }
}

//귤 k개를 고른다.
// 크기가 다른 종류 수 최소화

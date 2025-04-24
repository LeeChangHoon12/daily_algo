import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        int count = 0;
        while(!pq.isEmpty()){

            int food1 = pq.poll();
            //System.out.println(food1 + " " + K);
            if(food1 >= K){
                return count;
            }
            
            if(pq.isEmpty()){
                return -1;
            }
            
            int food2 = pq.poll();
            
            count++;
            pq.offer(food1 + food2*2);
        }
        
        return -1;
        
    }
}
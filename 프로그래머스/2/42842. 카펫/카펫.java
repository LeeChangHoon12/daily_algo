class Solution {
    public int[] solution(int brown, int yellow) {
       
        int[] answer = new int[2];
        
        int area = brown + yellow;
        //i = 가로 
      for(int i=3; i<area; i++){
          
        if(area%i != 0 ) continue;
          
        int j = area / i;
          
        if( (i-2)*(j-2) == yellow ){
            answer[0] = i;
            answer[1] = j;
        }
      }
        
        return answer;
        
    }
}
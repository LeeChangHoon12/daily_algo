import java.util.*;

class Solution
{
    public int solution(int[] A, int[] B)    {
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int min = Integer.MAX_VALUE;
        
        int sum = 0;

        
        for(int i=0;i<A.length; i++){
            sum += A[i]*B[A.length-1-i];
        }
        
        

        return sum;
    }
}
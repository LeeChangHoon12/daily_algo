class Solution {
    
    static int count = 0;
    
    public long solution(int n) {
        
        int[] dp = new int[n+2];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2])%1234567;
        }
        
        return dp[n]%1234567;
    }

}
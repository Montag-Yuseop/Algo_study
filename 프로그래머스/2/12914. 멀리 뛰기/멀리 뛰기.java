class Solution {
    public long solution(int n) {
        long answer = 0;
        
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 3;
        
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        
        for(int i = 4; i < n+1; i++) {
            dp[i] = (dp[i-2] + dp[i-1])%1234567;
        }
        
        System.out.println(dp[n]);
        
        return dp[n];
    }
}
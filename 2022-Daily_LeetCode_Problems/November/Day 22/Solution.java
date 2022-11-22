// https://leetcode.com/problems/perfect-squares/

class Solution {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        
        for(int i=0;i<=n;i++)dp[i] = Integer.MAX_VALUE;
        
        dp[0]=0;
        int ind=1;
        
        while(ind*ind <= n){
            int square = ind*ind;
            
            for(int i=square;i<=n;i++){
                dp[i] = Math.min(dp[i-square]+1,dp[i]);
            }
            ind++;
        }
        
        return dp[n];
    }
}

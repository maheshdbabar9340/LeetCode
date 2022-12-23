// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

class Solution {
    public int maxProfit(int[] prices){
        int len=prices.length;
        if(len==0)return 0;
        int[][] dp=new int[prices.length][3];
        dp[0][0]=dp[0][2]=0;
        dp[0][1]=-prices[0];
        int min_buy=dp[0][1];
        for(int i=1;i<len;i++){
            dp[i][0]=min_buy+prices[i];// sell
            dp[i][1]=dp[i-1][2]-prices[i];// buy
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][0]);
            min_buy=Math.max(min_buy, dp[i][1]);
        }
        return Math.max(dp[len-1][0],dp[len-1][2]);
    }
}

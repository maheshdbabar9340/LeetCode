// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
        int min_val = Integer.MAX_VALUE;
        int max_profit = 0;
        
        for(int i = 0; i < prices.length; i++) {
            if(min_val > prices[i]){
                min_val = prices[i];
            } else if(prices[i] - min_val > max_profit) {
                max_profit = prices[i] - min_val;
            }
        }
        return max_profit;
    }
}
// class Solution {
//     public int maxProfit(int[] prices) {
//         int min = Integer.MAX_VALUE;
//         int profit = 0;
//         int net = 0;
//         for(int i =0; i < prices.length; i++) {
//             if(min < prices[i]) {
//                 min = prices[i];
//             }else {
//                 profit = Math.max(profit, prices[i]-min);
//                 net = net+ profit;
//                 min = Integer.MAX_VALUE;
//                 profit= 0;
//             }
//         }
//         return net;
//     }
// }

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i<prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                profit = profit + prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
// O(n*n) = Time Complexity O(n) = Space Complexity
// class Solution {
//     public int maxProfit(int[] prices) {
//         int profit = 0;
//         for(int i=0; i< prices.length; i++) {
//             for(int j=i; j< prices.length; j++) {
//                 if(prices[i] < prices[j]){
//                     profit = Math.max(profit, prices[j]-prices[i]);
//                 }
//             }
//         }
//         return profit;
//     }
// }


// O(n) = Time Complexity O(1) = Space Complexity
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++) {
            if(prices[i]<min) {
                min = Math.min(min, prices[i]);
            }else{
                profit = Math.max(profit, prices[i] - min);
            }
        }
        return profit;
    }
}
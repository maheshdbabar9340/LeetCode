// https://leetcode.com/problems/min-cost-climbing-stairs/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        var downOne = 0;

        for (int downTwo = 0, i = 2; i - 1 < cost.length; i++) {
            var temp = downOne;
            downOne = Math.min(downOne + cost[i - 1],
                    downTwo + cost[i - 2]);
            downTwo = temp;
        }
        return downOne;
    }
}
// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

class Solution {
    public int numRollsToTarget(int n, int f, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= f; k++) {
                    if (j >= k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % 1000000007;
                    }
                }
            }
        }
        return dp[n][target];
    }
}

// https://leetcode.com/problems/coin-change/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int t[][] = new int[n + 1][amount + 1];
        return subsetmin(coins, amount, n, t);
    }

    public int subsetmin(int coins[], int sum, int n, int t[][]) {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0)
                    t[i][j] = Integer.MAX_VALUE - 1;
                if (j == 0)
                    t[i][j] = 0;
            }
        }

        for (int j = 1; j < sum + 1; j++) {
            if (j % coins[0] == 0)
                t[n][sum] = j / coins[0];
            else
                t[n][sum] = Integer.MAX_VALUE - 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = Math.min(t[i][j - coins[i - 1]] + 1, t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum] == Integer.MAX_VALUE - 1 ? -1 : t[n][sum];
    }
}
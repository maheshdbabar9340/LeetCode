// https://leetcode.com/problems/unique-paths/

// Approach 1: Using Dynamic Programming

class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        for (int i = 0; i < m; i++)
            dp[i][0] = 1;

        for (int i = 0; i < n; i++)
            dp[0][i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

// Approach 2: Using Recursion

class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(new HashMap<Pair, Integer>(), 0, 0, m, n);
    }

    private static int dfs(Map<Pair, Integer> cache, int r, int c, int rows, int cols) {
        Pair p = new Pair(r, c);

        if (cache.containsKey(p)) {
            return cache.get(p);
        }

        if (r == rows - 1 || c == cols - 1) {
            return 1;
        }

        cache.put(p, dfs(cache, r + 1, c, rows, cols) + dfs(cache, r, c + 1, rows, cols));
        return cache.get(p);
    }
}
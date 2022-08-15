// https://leetcode.com/problems/out-of-boundary-paths/

class Solution {
    Long[][][] memo = null;
    long mod = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new Long[m + 1][n + 1][maxMove + 1];
        return (int) findPathsHelper(m, n, maxMove, startRow, startColumn);
    }

    public long findPathsHelper(int m, int n, int maxMove, int row, int col) {
        if (maxMove < 0)
            return 0;
        if (row == m || col == n || row < 0 || col < 0)
            return 1;
        if (memo[row][col][maxMove] != null)
            return memo[row][col][maxMove];

        long leftPaths = findPathsHelper(m, n, maxMove - 1, row - 1, col);
        long rightPaths = findPathsHelper(m, n, maxMove - 1, row + 1, col);
        long topPaths = findPathsHelper(m, n, maxMove - 1, row, col - 1);
        long bottomPaths = findPathsHelper(m, n, maxMove - 1, row, col + 1);

        return memo[row][col][maxMove] = (leftPaths + rightPaths + topPaths + bottomPaths) % mod;
    }
}
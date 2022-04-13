// https://leetcode.com/problems/spiral-matrix-ii/

class Solution {
    Integer rowDir = 0, colDir = 1;

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int row = 0, col = 0;

        while (num <= n * n) {
            matrix[row][col] = num;

            int tempRow = row + rowDir;
            int tempCol = col + colDir;

            // Condition to change direction
            if (tempRow < 0 || tempCol < 0 || tempRow == n || tempCol == n || matrix[tempRow][tempCol] != 0) {
                changeDirection();
            }

            row += rowDir;
            col += colDir;

            num++;
        }

        return matrix;
    }

    public void changeDirection() {

        if (rowDir == 0 && colDir == 1) {
            // initial: right -> new: down
            colDir = 0;
            rowDir = 1;
        } else if (colDir == 0 && rowDir == 1) {
            // initial: down -> new: left
            rowDir = 0;
            colDir = -1;
        } else if (colDir == -1 && rowDir == 0) {
            // initial: left -> new: up
            rowDir = -1;
            colDir = 0;
        } else if (rowDir == -1 && colDir == 0) {
            // initial: up -> new: right
            colDir = 1;
            rowDir = 0;
        }
    }
}

// Second Solution

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int r1 = 0, r2 = n - 1;
        int c1 = 0, c2 = n - 1;
        int val = 1;

        while (r1 <= r2 && c1 <= c2) {

            // moving from left to right
            for (int c = c1; c <= c2; c++)
                ans[r1][c] = val++;

            // move down
            for (int r = r1 + 1; r <= r2; r++)
                ans[r][c2] = val++;

            // move right to left
            // move up

            if (r1 < r2 && c1 < c2) {
                // move right to left

                for (int c = c2 - 1; c > c1; c--)
                    ans[r2][c] = val++;

                for (int r = r2; r > r1; r--)
                    ans[r][c1] = val++;
            }

            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
}

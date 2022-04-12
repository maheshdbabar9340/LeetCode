class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countNeighbors(board, i, j);
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2) {
                        ans[i][j] = 0;
                    } else if (liveNeighbors == 2 || liveNeighbors == 3) {
                        ans[i][j] = 1;
                    } else if (liveNeighbors > 3) {
                        ans[i][j] = 0;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        ans[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ans[i][j];
            }
        }
    }

    private int countNeighbors(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int row = i, col = j, count = 0;

        if (row - 1 >= 0) {
            if (col - 1 >= 0 && board[row - 1][col - 1] == 1)
                count++;
            if (col >= 0 && board[row - 1][col] == 1)
                count++;
            if (col + 1 < n && board[row - 1][col + 1] == 1)
                count++;
        }
        if (row + 1 < m) {
            if (col - 1 >= 0 && board[row + 1][col - 1] == 1)
                count++;
            if (col >= 0 && board[row + 1][col] == 1)
                count++;
            if (col + 1 < n && board[row + 1][col + 1] == 1)
                count++;
        }
        if (col - 1 >= 0 && board[row][col - 1] == 1)
            count++;
        if (col + 1 < n && board[row][col + 1] == 1)
            count++;
        return count;

    }
}
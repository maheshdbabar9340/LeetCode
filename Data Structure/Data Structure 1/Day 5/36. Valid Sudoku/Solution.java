// https://leetcode.com/problems/valid-sudoku/

class Solution {
    public boolean isValid(char[][] board, int row, int col, char val) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val)
                return false;
            if (board[i][col] == val)
                return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val)
                return false;
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        boolean res = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (board[i][j] != '.') {
                        char val = board[i][j];
                        board[i][j] = '.';
                        res = isValid(board, i, j, val);
                        board[i][j] = val;
                    }
                    if (!res)
                        return res;
                }
            }
        }
        return true;
    }
}

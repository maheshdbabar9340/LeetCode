// https://leetcode.com/problems/reshape-the-matrix/

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        if (r * c != mat.length * mat[0].length) {
            return mat;
        }

        int[][] ans = new int[r][c];
        int a = 0, b = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (b == c) {
                    a++;
                    b = 0;
                }
                ans[a][b++] = mat[i][j];
            }
        }
        return ans;
    }
}
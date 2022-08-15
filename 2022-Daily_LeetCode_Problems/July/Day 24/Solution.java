// https://leetcode.com/problems/search-a-2d-matrix-ii/

// Solution 1:

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    break;
                }
            }
        }
        return false;
    }
}

// Solution 2:

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                j--;
            else if (matrix[i][j] < target)
                i++;
        }
        return false;
    }
}
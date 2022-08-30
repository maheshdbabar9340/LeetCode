// https://leetcode.com/problems/rotate-image/

class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {  // Converted into transpose of the matrix
            for(int j = i; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            } 
        }
        
        for(int i = 0; i < matrix.length; i++) { // Swapped all column elements till half of the length
            for(int j = 0; j < matrix.length/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = tmp;
            } 
        }
    }
}
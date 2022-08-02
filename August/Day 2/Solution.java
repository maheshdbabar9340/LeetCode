// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = 0;
        int[] arr = new int[matrix.length*matrix.length];
        int l = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                arr[l++] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }
}
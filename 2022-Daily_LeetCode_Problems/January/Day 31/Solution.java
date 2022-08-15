// https://leetcode.com/problems/richest-customer-wealth/

class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] arr : accounts) {
            int sum = 0;
            for (int i : arr) {
                sum += i;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
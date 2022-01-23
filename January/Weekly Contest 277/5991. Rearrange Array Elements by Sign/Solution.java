// https://leetcode.com/contest/weekly-contest-277/problems/rearrange-array-elements-by-sign/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        int[] positive = new int[len / 2];
        int[] negative = new int[len / 2];
        int j = 0, k = 0, l = 0, m = 0;
        for (int i : nums) {
            if (i > 0) positive[k++] = i;
            else negative[j++] = i;
        }
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) nums[i] = positive[l++];
            else nums[i] = negative[m++];
        }
        return nums;
    }
}
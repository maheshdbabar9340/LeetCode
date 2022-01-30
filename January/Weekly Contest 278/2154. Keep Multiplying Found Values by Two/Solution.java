// https://leetcode.com/problems/keep-multiplying-found-values-by-two/

class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == original) {
                original *= 2;
            }
        }
        return original;
    }
}
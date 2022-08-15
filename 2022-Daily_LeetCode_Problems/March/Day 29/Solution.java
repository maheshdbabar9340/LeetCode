// https://leetcode.com/problems/find-the-duplicate-number/

class Solution {
    public int findDuplicate(int[] nums) {
        for (int n : nums) {
            if (nums[Math.abs(n)] < 0)
                return Math.abs(n);
            else
                nums[Math.abs(n)] *= -1;
        }
        return -1;
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
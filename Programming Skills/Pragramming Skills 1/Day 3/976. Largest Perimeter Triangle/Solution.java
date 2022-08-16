// https://leetcode.com/problems/largest-perimeter-triangle/

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 0;
        for (int i = n - 1; i > 1; i--) {
            if (nums[i] + nums[i - 1] > nums[i - 2] && nums[i - 1] + nums[i - 2] > nums[i]
                    && nums[i] + nums[i - 2] > nums[i - 1])
                max = (int) Math.max(max, nums[i] + nums[i - 1] + nums[i - 2]);
        }
        return max;
    }
}
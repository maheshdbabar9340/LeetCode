// https://leetcode.com/problems/3sum-closest/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int a_pointer = i + 1;
            int b_pointer = nums.length - 1;

            while (a_pointer < b_pointer) {
                int curr_sum = nums[i] + nums[a_pointer] + nums[b_pointer];
                if (curr_sum > target) {
                    b_pointer--;
                } else {
                    a_pointer++;
                }

                if (Math.abs(curr_sum - target) < Math.abs(result - target)) {
                    result = curr_sum;
                }
            }
        }
        return result;
    }
}
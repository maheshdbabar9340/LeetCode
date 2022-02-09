// https://leetcode.com/problems/array-partition-i/

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i=i+2) {
            sum += Math.min(nums[i], nums[i+1]);
        }
        return sum;
    }
}
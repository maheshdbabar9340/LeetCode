// https://leetcode.com/problems/missing-number/

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return n * (n + 1) / 2 - sum;
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
            sum2 += i;
        }
        sum2 += nums.length;
        return sum2 - sum1;
    }
}
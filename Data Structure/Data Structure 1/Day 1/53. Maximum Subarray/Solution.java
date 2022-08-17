// https://leetcode.com/problems/maximum-subarray/

// First Solution : Using Naive Approach - O(n^2) time complexity

class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}

// Second Solution : Using Divide and Conquer Approach

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = -(int) 1e6;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < nums[i]) {
                sum = nums[i];
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}

// Third Solution

class Solution {
    public int maxSubArray(int[] nums) {

        int maxsum = Integer.MIN_VALUE;
        int currsum = 0;

        for (int n : nums) {

            currsum += n;
            maxsum = Math.max(currsum, maxsum);

            if (currsum < 0)
                currsum = 0;
        }

        return maxsum;
    }
}

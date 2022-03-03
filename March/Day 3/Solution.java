// Approach 1 : Time Complexity = O(n) Space Complexity = O(n)

// ==> dp array is used for storing previous iteration value if the difference is equal.

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                res += dp[i];
            }
        }
        return res;
    }
}

// Approach 2 : Time Complexity = O(n) Space Complexity = O(1)

// ==> dp integer is used for storing previous iteration value if the difference
// is equal else we will set it to 0 as difference is not equal.

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int dp = 0;
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp = 1 + dp;
                res += dp;
            } else {
                dp = 0;
            }
        }
        return res;
    }
}

// Approach 3 : Time Complexity = O(n) Space Complexity = O(1)

// ==> Using arithmetic formula for consecutive numbers as difference is equal.

// Formula = n * (n + 1) / 2 // Sum of first n natural numbers as we will count
// all numbers with equal difference.

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                count++;
            } else {
                res = res + (count * (count + 1) / 2);
                count = 0;
            }
        }
        return res + (count * (count + 1) / 2); // if arithmetic sequence goes till end of the for loop
    }
}
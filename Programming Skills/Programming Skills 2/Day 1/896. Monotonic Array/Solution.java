// https://leetcode.com/problems/monotonic-array/

// First Solution : Using Sorting

class Solution {
    public boolean isMonotonic(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        if (arr[0] == nums[0]) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != arr[i])
                    return false;
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != arr[nums.length - i - 1])
                    return false;
            }
        }
        return true;
    }
}

// Second Solution : Using simple tracing for each iteration for checking
// decending or ascending

class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2)
            return true;
        boolean dec = true;
        boolean inc = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                dec = false;
            }
            if (nums[i] > nums[i - 1]) {
                inc = false;
            }
        }
        return inc || dec;
    }
}
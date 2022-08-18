// https://leetcode.com/problems/two-sum/

// First Solution : Brute Force Approach - TC : O(n^2)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] { i, j };
            }
        }
        return nums;
    }
}

// Second Solution : Optimsed Approach Using HashTable - TC : O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {

            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                ans[0] = i;
                ans[1] = map.get(diff);
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}

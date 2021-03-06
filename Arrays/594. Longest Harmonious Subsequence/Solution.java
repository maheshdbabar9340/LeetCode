// https://leetcode.com/problems/longest-harmonious-subsequence/

class Solution {
    public int findLHS(int[] nums) {
        int result = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        for (int i : count.keySet()) {
            if (count.containsKey(i + 1)) {
                result = Math.max(result, count.get(i) + count.get(i + 1));
            }
        }
        return result;
    }
}

class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = 1;
        int result = 0;
        while (right < nums.length) {
            int diff = nums[right] - nums[left];
            if (diff == 1) {
                result = Math.max(result, right - left + 1);
            }
            if (diff <= 1) {
                right++;
            } else {
                left++;
            }
        }
        return result;
    }
}
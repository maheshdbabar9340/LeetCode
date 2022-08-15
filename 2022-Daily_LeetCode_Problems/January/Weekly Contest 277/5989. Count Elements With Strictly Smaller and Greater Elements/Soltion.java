// https://leetcode.com/contest/weekly-contest-277/problems/count-elements-with-strictly-smaller-and-greater-elements/

class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[0] && nums[i] < nums[nums.length - 1])
                count++;
        }
        return count;
    }
}
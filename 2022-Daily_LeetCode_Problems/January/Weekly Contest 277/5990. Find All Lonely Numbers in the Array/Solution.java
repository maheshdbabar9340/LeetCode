// https://leetcode.com/contest/weekly-contest-277/problems/find-all-lonely-numbers-in-the-array/

class Solution {
    public List<Integer> findLonely(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int k = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (len == 1) {
            arr.add(nums[0]);
            return arr;
        }
        if (nums[0] != nums[1] && nums[1] != nums[0] + 1)
            arr.add(nums[0]);
        for (int i = 1; i < len - 1; i++) {
            if (nums[i - 1] != nums[i] - 1 && nums[i - 1] != nums[i] && nums[i + 1] != nums[i] + 1 && nums[i + 1] != nums[i])
                arr.add(nums[i]);
        }
        if (nums[len - 1] != nums[len - 2] && nums[len - 1] != nums[len - 2] + 1)
            arr.add(nums[len - 1]);

        return arr;
    }
}
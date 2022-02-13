// https://leetcode.com/problems/subsets/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        res.add(path);
        helper(nums, res, 0, path);
        return res;
    }
    
    private void helper(int[] nums, List<List<Integer>> res, int idx, List<Integer> path) {
        for(int i=idx; i<nums.length; i++) {
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            helper(nums, res, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
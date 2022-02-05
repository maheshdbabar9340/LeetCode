// https://leetcode.com/contest/biweekly-contest-71/problems/partition-array-according-to-given-pivot/

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int count= 0;
        int same = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < pivot){
                count++;
            }
            if(nums[i] == pivot) {
                same++;
            }
        }
        int left = 0;
        int mid = count;
        int right = count + same;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot) {
                ans[left++] = nums[i];
            } else if(nums[i] == pivot){
                ans[mid++] = nums[i];
            } else {
                ans[right++] = nums[i];
            }
        }
        return ans;
    }
}
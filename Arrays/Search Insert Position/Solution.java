class Solution {
    int index;
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                index = i;
                break;
            }
            else{
                if(i == 0 && target < nums[i]) {
                    index = 0;
                    break;
                }
                else if(i == nums.length - 1 && target > nums[i]) {
                    index = nums.length;
                    break;
                }
                else if(target > nums[i] && target < nums[i+1]) {
                    index = i + 1;
                    break;
                }
            }
        }
        return index;
    }
}
// Intuition behind solution: Set a variable called index to zero (index will keep  track of where to place number that are not equal to val). Iterate through the array of numbers and in each iteration check if the current number is not equal to val. If the current number is not equal to val, place the current number in the array at nums[index] and increment index by one. Once you have gone through all the numbers, index will be equal to the length of the new array; therefore, we return it.


class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
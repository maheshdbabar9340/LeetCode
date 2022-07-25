// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// First Approach : Using while loop

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                first = i;
                int j = i;
                while (j < nums.length) {
                    if (nums[j] == target) {
                        last = j;
                    } else {
                        break;
                    }
                    j++;
                }
                break;
            }
        }
        return new int[] { first, last };
    }
}

// Second Approach : Using two seperate loops

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                first = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                last = i;
                break;
            }
        }
        return new int[] { first, last };
    }
}
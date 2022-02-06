// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

class Solution {
    public int removeDuplicates(int[] nums) {
        var n = nums.length;
        if (n < 3)
            return n;

        var i = 2;
        for (var j = i; j < n; j++)
            if (nums[j] != nums[i - 2])
                nums[i++] = nums[j];

        return i;
    }
}
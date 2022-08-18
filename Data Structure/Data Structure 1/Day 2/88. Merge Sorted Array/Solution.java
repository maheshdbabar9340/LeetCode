// https://leetcode.com/problems/merge-sorted-array/

// First Solution : Using System.arraycopy() method

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;

        int len = m + n - 1;

        while (len1 >= 0 && len2 >= 0) {
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }

        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }
}

// Second Solution : Using Sorting

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
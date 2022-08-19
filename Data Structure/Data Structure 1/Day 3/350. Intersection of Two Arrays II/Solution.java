// https://leetcode.com/problems/intersection-of-two-arrays-ii/

// First Approach : Counting all intersetction of two arrays
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int count = 0;
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] == nums2[j]) {
                count++;
                i++;
                j++;
            }
        }
        int[] ans = new int[count];
        int k = 0;
        i = 0;
        j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] == nums2[j]) {
                ans[k++] = nums1[i];
                i++;
                j++;
            }
        }
        return ans;
    }
}

// Second Approach : Counting all intersetction of two arrays in ArrayList

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> l = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                l.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] arr = new int[l.size()];

        for (int k = 0; k < l.size(); k++) {
            arr[k] = (int) l.get(k);
        }
        return arr;

    }
}
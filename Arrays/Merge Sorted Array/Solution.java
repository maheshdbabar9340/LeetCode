// Approach 1 : Copy elements of second array into first and sort the merged array.
// Time complexity : O(K logK) where K is m+n    
// Space Complexity : O(1) Storing it into original array

// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
// 	System.arraycopy(nums2, 0, nums1, m, n);
// 	Arrays.sort(nums1);
//     }
// }

//Approach 2 : Two pointer approach
//Time complexity : O(K)
//Space Complexity : O(1)

class Solution{
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int p1 = m-1, p2 = n-1, i = m+n-1;
        while(p2 >= 0){
            if(p1 >= 0 && nums1[p1]>nums2[p2]){
                nums1[i--] = nums1[p1--];    
            }
            else{
                nums1[i--] = nums2[p2--];
            }
        }
    }
}
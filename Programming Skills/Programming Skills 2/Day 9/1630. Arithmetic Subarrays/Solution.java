// https://leetcode.com/problems/arithmetic-subarrays/

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList();

        for (int i = 0; i < l.length; i++) {
            int a = l[i];
            int b = r[i];
            int[] check = new int[b - a + 1];
            int m = 0;
            for (int j = a; j <= b; j++) { // Created new check array
                check[m++] = nums[j];
            }
            ans.add(chk(check));
        }
        return ans;
    }

    public boolean chk(int[] arr) { // Whether array is arithmetic or not
        Arrays.sort(arr);
        if (arr.length < 3) {
            return true;
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] - arr[i - 1] != arr[i + 1] - arr[i]) {
                return false;
            }
        }
        return true;
    }
}
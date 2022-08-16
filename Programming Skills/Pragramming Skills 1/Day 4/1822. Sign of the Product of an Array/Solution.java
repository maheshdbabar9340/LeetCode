// https://leetcode.com/problems/sign-of-the-product-of-an-array/

class Solution {
    public int arraySign(int[] nums) {
        int ans = 1;
        for (int i : nums)
            if (i < 0)
                ans *= -1;
            else if (i == 0)
                return 0;
        return ans;
    }
}
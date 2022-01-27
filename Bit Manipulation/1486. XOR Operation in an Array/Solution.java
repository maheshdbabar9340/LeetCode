// https://leetcode.com/problems/xor-operation-in-an-array/

class Solution {
    public int xorOperation(int n, int start) {
        int res = 0;
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
            res ^= nums[i];
        }
        return res;
    }
}
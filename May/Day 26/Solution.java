// https://leetcode.com/problems/number-of-1-bits/

public class Solution {
    public int hammingWeight(int n) {
        int num = n;
        int count = 0;
        while (num != 0) {
            int mask = num & (-num);
            num = num - mask;
            count++;
        }
        return count;
    }
}
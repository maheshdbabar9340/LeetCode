// https://leetcode.com/problems/divide-two-integers/

class Solution {
    public int divide(int dividend, int divisor) {
        boolean neg = (dividend < 0) ^ (divisor < 0); // is the result negative?
        int ans = 0, mul = 0;
        dividend = -Math.abs(dividend); // make everything negative.
        divisor = -Math.abs(divisor);
        while (divisor >= (Integer.MIN_VALUE >> 1) && divisor >= dividend) {
            divisor <<= 1;
            mul++; // track power of 2 position
        }
        while (mul >= 0) { // do this until the power of 2 position is less than 0
            if (divisor >= dividend) { // if divisor is >= dividend, then we set the bit and subtract it.
                ans -= (1 << mul);
                dividend -= divisor;
            }
            divisor >>= 1;
            mul--;
        }
        return neg ? ans : // return ans if neg is set, otherwise return MAX_INT if ans is MIN_INT, and
                           // return -ans for all the remaining cases.
                ans == Integer.MIN_VALUE ? Integer.MAX_VALUE : -ans;
    }
}
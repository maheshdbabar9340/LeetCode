class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 3 || n == 1) {
            return true;
        }
        if (n % 3 != 0 || n == 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
        // return n > 0 ? Math.pow(3, 19) % n == 0 : false;
    }
}
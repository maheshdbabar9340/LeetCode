class Solution {
    public boolean isPalindrome(int x) {
        if (x >= 0) {
            int y = x, res = 0;
            while (x > 0) {
                res = res * 10 + x % 10;
                x = x / 10;
            }
            if (res == y) {
                return true;
            }
        }
        return false;
    }
}
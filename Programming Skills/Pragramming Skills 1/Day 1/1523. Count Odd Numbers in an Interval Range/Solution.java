// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

class Solution {
    public int countOdds(int low, int high) {
        int diff = high - low + 1;
        if (low % 2 == 1 && high % 2 == 1) {
            return diff / 2 + 1;
        }
        return diff / 2;
    }
}
// https://leetcode.com/problems/can-place-flowers/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int prev = (i == 0 || flowerbed[i - 1] == 0) ? 0 : 1; // check for first and prev ele is 0 or 1
                int next = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) ? 0 : 1; // check for last and next ele
                                                                                         // is 0 or 1

                if (prev == 0 && next == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
}
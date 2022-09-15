// https://leetcode.com/problems/find-original-array-from-doubled-array/

class Solution {
    // counting sort approach
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length, j = 0;
        // if the length of the input is odd, then return []
        // because doubled array must have even length
        if (n % 2 == 1) return new int[]{};
        int[] ans = new int[n / 2];
        // alternatively, you can find the max number in `changed`
        // then use new int[2 * mx + 1]
        int[] cnt = new int[200005];
        // count the frequency of each number
        for (int x : changed) cnt[x] += 1;
        // iterate from 0 to max number
        for (int i = 0; i < 200005; i++) {
            // check if the count of number i is greater than 0
            if (cnt[i] > 0) {
                // number i exists, decrease by 1
                cnt[i] -= 1;
                // look for the doubled value
                if (cnt[i * 2] > 0) {
                    // doubled value exists, decrease by 1
                    cnt[i * 2] -= 1;
                    // add this number to ans
                    ans[j++] = i--;
                } else {
                    // cannot pair up, return []
                    return new int[]{};
                }
            }
        }
        return ans;
    }
}

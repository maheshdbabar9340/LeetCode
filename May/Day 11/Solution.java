// https://leetcode.com/problems/count-sorted-vowel-strings/

class Solution {
    int count = 0;
    char[] characters = new char[] { 'a', 'e', 'i', 'o', 'u' };

    public int countVowelStrings(int n) {
        helper(n, ' ', 0);
        return count;
    }

    public void helper(int n, char pre, int index) {
        if (n == 0 || pre > characters[index]) {
            count += n == 0 ? 1 : 0;
            return;
        }
        for (int i = index; i < characters.length; i++) {
            helper(n - 1, characters[i], i);
        }
    }
}

class Solution {
    public int countVowelStrings(int n) {
        int[] dp = new int[] { 0, 1, 1, 1, 1, 1 };
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[5];
    }
}
// https://leetcode.com/problems/repeated-substring-pattern/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();

        for (int div = len / 2; div >= 1; div--) {
            // If div is divisible
            if (len % div == 0) {
                String sub = s.substring(0, div); // Current substring
                int subLen = sub.length();
                int i = 0;

                // Check each substring in s, if it is equal to sub
                while (i < s.length()) {
                    if (!sub.equals(s.substring(i, i + subLen)))
                        break;
                    i += subLen;
                }

                // If we have reached end of the String then definitely we have found our answer
                if (i >= s.length())
                    return true;
            }
        }
        return false;
    }
}
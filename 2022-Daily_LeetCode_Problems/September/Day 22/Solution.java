// https://leetcode.com/problems/reverse-words-in-a-string-iii/

class Solution {
    public String reverseWords(String s) {
        int l = 0, r = 0, n = s.length();
        char[] c = s.toCharArray();
        for (int i = 0; i < n; i++) {
            // looking for the space index
            if (c[i] == ' ' || i == n - 1) {
                // r is the index before the space
                // if s[i] is space, then we want to reverse s[l : i - 1]
                // if s[i] is the last character, then we want to reverse s[l : i]
                r = i == n - 1 ? i : i - 1;
                // swap the character
                // e.g. s = `Let's` where l is 0 and r is 4
                // Let's -> set'L -> s'teL
                while (l < r) {
                    char tmp = c[l];
                    c[l] = c[r];
                    c[r] = tmp;
                    l++;
                    r--;
                }
                // update left pointer which is i + 1
                // i.e. the first index of the next word if applicable
                l = i + 1;
            }
        }
        return new String(c);
    }
}

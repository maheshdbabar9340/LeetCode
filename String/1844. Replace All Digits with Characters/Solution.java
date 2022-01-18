// https://leetcode.com/problems/replace-all-digits-with-characters/

class Solution {
    public String replaceDigits(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c <= '9' && c >= '0' && i - 1 >= 0) {
                char newChar = (char) (s.charAt(i - 1) + c - '0');
                ans.append(newChar);
                continue;
            }
            ans.append(c);
        }
        return ans.toString();
    }
}
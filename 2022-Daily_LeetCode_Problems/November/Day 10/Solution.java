// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            // if the current character is same as the last one in `sb`
            // then we cannot push it to `sb`
            // we remove the one in `sb`
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) sb.deleteCharAt(sb.length() - 1);
            // otherwise, add the current character to `sb`
            else sb.append(c);
        }
        return sb.toString();
    }
}

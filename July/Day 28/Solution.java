// https://leetcode.com/problems/valid-anagram/

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        char cs[] = s.toCharArray();
        char ct[] = t.toCharArray();

        Arrays.sort(cs);
        Arrays.sort(ct);

        for (int i = 0; i < s.length(); i++) {
            if (cs[i] != ct[i])
                return false;
        }
        return true;
    }
}
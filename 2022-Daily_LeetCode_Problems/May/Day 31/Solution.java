// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> codes = new HashSet<>();
        int total = 1 << k;

        for (int i = 0; i + k <= s.length(); i++) {
            codes.add(s.substring(i, i + k));
            if (codes.size() == total)
                return true;
        }

        return false;
    }
}
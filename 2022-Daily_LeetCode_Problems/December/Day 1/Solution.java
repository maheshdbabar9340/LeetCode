// https://leetcode.com/problems/determine-if-string-halves-are-alike/

class Solution {
    Set<Character> vwls = Set.of('a','e','i','o','u','A','E','I','O','U');
    public boolean halvesAreAlike(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i)
            if (vwls.contains(s.charAt(i)))
                cnt += (int)Math.signum(s.length() - 2*i-1);
        return cnt == 0;
    }
}

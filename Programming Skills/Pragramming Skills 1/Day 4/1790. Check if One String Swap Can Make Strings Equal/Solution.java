// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int num = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) {
                list.add(i);
                count++;
            }
            if (count > 2)
                return false;

        }

        if (count == 2) {
            int x = list.get(0);
            int y = list.get(1);

            if (s1.charAt(x) == s2.charAt(y) &&
                    s1.charAt(y) == s2.charAt(x))
                return true;
        }
        if (count == 0)
            return true;

        return false;
    }
}
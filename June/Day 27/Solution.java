// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

class Solution {
    public int minPartitions(String n) {
        int len = n.length();
        String[] str = new String[len];

        for (int i = 0; i < len; i++) {
            str[i] = n.charAt(i) + "";
        }
        int[] intarr = new int[len];

        for (int i = 0; i < len; i++) {
            intarr[i] = Integer.parseInt(str[i]);
        }

        int check = 0;
        for (int i = 0; i < len; i++) {
            if (check < intarr[i]) {
                check = intarr[i];
            }
        }
        return check;
    }
}
// https://leetcode.com/problems/number-of-1-bits/

// First Approach : Using toBinarString() method

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        String s = Integer.toBinaryString(n);

        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                count++;
        }
        return count;
    }
}

// Second Approach : Using bitwise operator

public class Solution {
    public int hammingWeight(int n) {
        int num = n;
        int count = 0;
        while (num != 0) {
            int mask = num & (-num);
            num = num - mask;
            count++;
        }
        return count;
    }
}
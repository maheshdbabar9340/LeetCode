// https://leetcode.com/problems/implement-strstr/

// First Solution : Using indexOf() method
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

// Second Solution: Using simple tracing

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;
        int i = 0;
        int j = needle.length();
        while ((i + j) <= haystack.length()) {
            if (haystack.substring(i, i + j).equals(needle))
                return i;
            i++;
        }
        return -1;
    }
}
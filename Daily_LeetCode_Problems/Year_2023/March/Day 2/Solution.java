// Leetcode 28 

class Solution {   
    public int strStr(String string, String substring) {
        int n = string.length();
        int m = substring.length();
        if (m > n) {
            return -1;
        }
        int prime = 101;
        int power = 1;
        int substringHash = 0;
        int stringHash = 0;

        // Calculate hash value of substring and first substring of string
        for (int i = 0; i < m; i++) {
            substringHash += substring.charAt(i) * Math.pow(prime, i);
            stringHash += string.charAt(i) * Math.pow(prime, i);
        }

        // Compare hash values and actual substrings
        for (int i = 0; i < n - m + 1; i++) {
            if (substringHash == stringHash && string.substring(i, i + m).equals(substring)) {
                return i;
            }

            // Calculate hash value of next substring of string
            if (i < n - m) {
                stringHash = (stringHash - string.charAt(i)) / prime;
                stringHash += string.charAt(i + m) * Math.pow(prime, m - 1);
            }
        }

        return -1;
    }
}

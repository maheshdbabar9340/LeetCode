// https://leetcode.com/problems/first-unique-character-in-a-string/

// First Approach : Using indexOf() and lastIndexOf() method 

class Solution {
    public int firstUniqChar(String s) {
        // Stores lowest index / first index
        int ans = Integer.MAX_VALUE;
        // Iterate from a to z which is 26 which makes it constant
        for (char c = 'a'; c <= 'z'; c++) {
            // indexOf will return first index of alphabet and lastIndexOf will return last
            // index
            // if both are equal then it has occured only once.
            // through this we will get all index's which are occured once
            // but our answer is lowest index
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                ans = Math.min(ans, index);
            }
        }

        // If ans remain's Integer.MAX_VALUE then their is no unique character
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

// Second Approach : Counting Frequencies of each character and then searching
// through array

class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) { // Count frequency of each character till z
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) { // Search for first unique character
            if (arr[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
// https://leetcode.com/problems/excel-sheet-column-number/

// Approach 1:Time Complexity:O(n)

class Solution {
    public int titleToNumber(String columnTitle) {
        int position = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            position = position * 26;
            for (int j = 'A'; j <= 'Z'; j++) {
                position++;
                if (j == columnTitle.charAt(i))
                    break;
            }
        }
        return position;
    }
}

// Approach 2: Time Complexity: O(n)

class Solution {
    public int titleToNumber(String columnTitle) {
        int position = 0;
        for (char c : columnTitle.toCharArray()) {
            position = position * 26 + (int) c - (int) 'A' + 1;
        }
        return position;
    }
}
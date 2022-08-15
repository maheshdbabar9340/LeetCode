// https://leetcode.com/problems/reverse-string/

// First Approach : Using Swap

class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }
}

// Second Approach : Using Stack

class Solution {
    public void reverseString(char[] s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }
        for (int i = 0; i < s.length; i++) {
            s[i] = stack.pop();
        }
    }
}
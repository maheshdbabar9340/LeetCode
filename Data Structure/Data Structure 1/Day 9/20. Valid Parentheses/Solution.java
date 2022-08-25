// https://leetcode.com/problems/valid-parentheses/

class Solution {
    Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if ((c == '(') || (c == '{') || (c == '[')) {
                stack.push(c);
            } else {
                if (stack.empty())
                    return false;
                char cc = stack.peek();
                if ((c == ')' && cc == '(') || ((c == '}' && cc == '{')) || ((c == ']' && cc == '['))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.empty())
            return true;
        return false;
    }
}
// https://leetcode.com/problems/score-of-parentheses/

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int score = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(score);
                score = 0;
            } else {
                score = stack.pop() + Math.max(score * 2, 1);
            }
        }
        return score;
    }
}
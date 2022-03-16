// https://leetcode.com/problems/validate-stack-sequences/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j] && j < popped.length) {
                j++;
                stack.pop();
            }
        }
        return j == popped.length;
    }
}
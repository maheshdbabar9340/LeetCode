// https://leetcode.com/problems/baseball-game/

class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new LinkedList<>();
        for (String val : ops) {
            if ("+".equals(val)) {
                int op1 = stack.pop();
                int op2 = op1 + stack.peek();
                stack.push(op1);
                stack.push(op2);
            } else if ("C".equals(val)) {
                stack.pop();
            } else if ("D".equals(val)) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.parseInt(val));
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}

class Solution {
    public int calPoints(String[] ops) {
        int[] stack = new int[ops.length];
        int i = -1;
        int total = 0;
        for (String s : ops) {
            char first = s.charAt(0);
            switch (first) {
                case 'D':
                    stack[i + 1] = stack[i] << 1;
                    i++;
                    total += stack[i];
                    break;
                case '+':
                    stack[i + 1] = stack[i] + stack[i - 1];
                    i++;
                    total += stack[i];
                    break;
                case 'C':
                    total -= stack[i];
                    i--;
                    break;
                default:
                    stack[++i] = Integer.parseInt(s);
                    total += stack[i];
            }
        }
        return total;
    }
}
// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

class Solution {
    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> s = new Stack<>();
        for (String token : tokens) {
            try {
                s.add(Integer.parseInt(token));
            } catch (Throwable e) {
                a = s.pop();
                b = s.pop();
                switch (token) {
                    case "+": s.add(b + a); break;
                    case "-": s.add(b - a); break;
                    case "*": s.add(b * a); break;
                    case "/": s.add(b / a); break;
                }
            }
        }
        return s.pop();
    }
}

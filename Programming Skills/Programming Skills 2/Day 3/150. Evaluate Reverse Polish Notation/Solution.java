// https://leetcode.com/problems/evaluate-reverse-polish-notation/

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {

            // if operator then remove top 2 elements from stack, perform arithmetic
            // operation on them and push result into stack
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int first = st.pop();
                int second = st.pop();
                if (token.equals("+"))
                    st.push(second + first);
                else if (token.equals("-"))
                    st.push(second - first);
                else if (token.equals("*"))
                    st.push(second * first);
                else
                    st.push(second / first);
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}
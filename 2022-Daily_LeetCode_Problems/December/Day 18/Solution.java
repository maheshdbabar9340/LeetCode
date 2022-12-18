// https://leetcode.com/problems/daily-temperatures/description/

import java.util.*;
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stk.isEmpty() && T[stk.peek()] < T[i]) {
                int index = stk.pop();
                result[index] = i - index;
            }
            stk.push(i);
        }
        return result;
    }
}

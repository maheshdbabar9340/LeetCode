// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
import java.util.*;

class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        double total = 0;
        for (int i = 1; i < salary.length - 1; i++) {
            total += salary[i];
        }
        return total / (salary.length - 2);
    }
}
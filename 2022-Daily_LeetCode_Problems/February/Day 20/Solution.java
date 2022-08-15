// https://leetcode.com/problems/remove-covered-intervals/

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] curr = new int[] { -1, -1 };
        int res = 0;
        for (int[] elem : intervals) {
            if (elem[0] > curr[0] && elem[1] > curr[1]) {
                curr[0] = elem[0];
                res++;
            }
            curr[1] = Math.max(curr[1], elem[1]);
        }
        return res;
    }
}
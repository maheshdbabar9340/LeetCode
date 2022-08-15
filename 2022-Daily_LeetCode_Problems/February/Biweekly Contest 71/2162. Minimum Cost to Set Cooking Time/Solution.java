// https://leetcode.com/contest/biweekly-contest-71/problems/minimum-cost-to-set-cooking-time/

class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int maxmins = targetSeconds / 60, ans = Integer.MAX_VALUE;
        for (int mins = 0; mins <= maxmins; mins++) {
            int secs = targetSeconds - mins * 60;
            if (secs > 99 || mins > 99) continue;
            ans = Math.min(ans, cost(mins, secs, startAt, moveCost, pushCost));
        }
        return ans;
    }
    private int cost(int mins, int secs, int startAt, int moveCost, int pushCost) {
        String s = Integer.toString(mins * 100 + secs); char curr = (char)(startAt + '0');
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == curr) res += pushCost;
            else {
                res += pushCost + moveCost;
                curr = s.charAt(i);
            }
        }
        return res;
    }
}
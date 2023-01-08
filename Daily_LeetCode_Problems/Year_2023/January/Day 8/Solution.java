// https://leetcode.com/problems/max-points-on-a-line/description/

import java.math.BigDecimal;
import java.math.RoundingMode;

class Solution {
    public int maxPoints(int[][] points) {
        int max = 1;
        for(int i = 0; i < points.length; i++) {
            Map<Double, Integer> slopeCnt = new HashMap<>();
            for(int j = i + 1; j < points.length; j++) {
                Double s = slope(points[i], points[j]);
                slopeCnt.put(s, slopeCnt.getOrDefault(s, 1) + 1);
                max = Math.max(max, slopeCnt.get(s));
            }
        }
        return max;
    }

    private Double slope(int[] p1, int[] p2) {
        double ydiff = p2[1] - p1[1];
        double xdiff = p2[0] - p1[0];

        // maybe return null for xdiff == 0?
        if(xdiff == 0) {
            return null;
        }

        double res = ydiff / xdiff;
        return round(res, 9);
    }

    // courtesy of https://stackoverflow.com/a/2808648/5699669
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

// https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        // find all valid points - Takes O(n)
        // for every valid point, find manhattan distance - O(n) worst case and maintain
        // a min.
        // return the index of the min manhattan distance. - O(1)

        int index = -1;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                // valid point.
                int man = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (distance > man) {
                    index = i;
                }
                distance = Math.min(distance, man);
            }
        }

        return index;
    }
}
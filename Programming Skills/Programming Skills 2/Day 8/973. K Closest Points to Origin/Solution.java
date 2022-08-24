// https://leetcode.com/problems/k-closest-points-to-origin/

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((p2, p1) -> Integer.compare(
                points[p1][0] * points[p1][0] + points[p1][1] * points[p1][1], // no need for sqrt
                points[p2][0] * points[p2][0] + points[p2][1] * points[p2][1]));

        for (int i = 0; i < points.length; i++) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; !queue.isEmpty(); i++) {
            res[i] = points[queue.poll()];
        }
        return res;
    }
}
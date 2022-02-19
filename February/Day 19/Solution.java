// Approach 1 - Using TreeSet

// Time Complexity :- O(NlogNlogM)
// Space Complexity :- O(N)

class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<Integer>();

        for (int i : nums) {
            if (i % 2 == 1)
                i *= 2;
            ts.add(i);
        }

        int diff = Integer.MAX_VALUE;
        while (true) {
            int max = ts.last();
            int min = ts.first();
            diff = Math.min(diff, max - min);
            if (max % 2 == 0) {
                ts.remove(max);
                ts.add(max / 2);
            } else {
                break;
            }
        }

        return diff;
    }
}
// Approach 2 - Using PriorityQueue

// Time Complexity = O(NlogNlogM)
// Space Complexity = O(N)

class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);

        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i % 2 == 1)
                i *= 2;
            min = Math.min(i, min);
            pq.add(i);
        }

        int diff = Integer.MAX_VALUE;
        while (pq.peek() % 2 == 0) {
            int max = pq.remove();
            diff = Math.min(diff, max - min);
            min = Math.min(max / 2, min);
            pq.add(max / 2);
        }

        return Math.min(diff, pq.peek() - min);
    }
}
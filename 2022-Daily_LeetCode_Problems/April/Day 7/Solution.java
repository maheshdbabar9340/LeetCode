// https://leetcode.com/problems/last-stone-weight/

class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);

        for (int i = stones.length - 1; i > 0; i--) {
            stones[i - 1] = stones[i] - stones[i - 1];
            Arrays.sort(stones);
        }
        return stones[0];
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int v : stones) {
            maxHeap.offer(v);
        }
        int x;
        int y;
        while (maxHeap.size() > 1) {
            y = maxHeap.poll();
            x = maxHeap.poll();
            if (y > x) {
                maxHeap.offer(y - x);
            }
        }
        if (maxHeap.size() == 0)
            return 0;
        return maxHeap.poll();
    }
}

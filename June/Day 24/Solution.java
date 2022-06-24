// https://leetcode.com/problems/construct-target-array-with-multiple-sums/

class Solution {
    public boolean isPossible(int[] target) {
        int n = target.length;

        // Approach : Reverse Engineering
        // try to contruct initial array [1, 1, 1] from the target array

        // base case
        if (n == 1)
            return target[0] == 1;

        // Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));

        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += target[i];

            // ignore 1
            if (target[i] == 1)
                continue;

            maxHeap.add(target[i]);
        }

        while (!maxHeap.isEmpty()) {
            int largest = maxHeap.remove();

            // total sum except current laregest number
            long remainingSum = (totalSum - largest);

            // Edge case
            // when n = 2,
            if (remainingSum == 1)
                return true;

            // invalid case, largest numbers must be greater than
            // sum of other number except largest number
            if (remainingSum >= largest)
                return false;

            int newLargest = (int) (largest % remainingSum);

            // newLargest can't be less 1
            if (newLargest < 1)
                return false;

            // no need to 1, in maxheap
            // avoid unnecessary adding and removing from heap
            if (newLargest > 1)
                maxHeap.add(newLargest);

            totalSum = totalSum - largest + newLargest;
        }

        return true;
    }
}
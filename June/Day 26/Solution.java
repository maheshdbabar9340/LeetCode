// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

class Solution {
    public int maxScore(int[] arr, int k) {
        int n = arr.length;

        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        if (k == n) {
            return totalSum;
        }

        else if (k == 1) {
            return Math.max(arr[0], arr[n - 1]);
        }

        int i = 0, j = n - k - 1;
        int currSum = 0;
        for (int idx = 0; idx <= n - k - 1; idx++) {
            currSum += arr[idx];
        }
        int minSum = currSum;

        while (i < n && j < n) {
            int temp = arr[i];
            i++;
            j++;
            if (j == n) {
                break;
            } else {
                currSum += arr[j];
                currSum -= temp;
            }
            minSum = Math.min(currSum, minSum);
        }

        return totalSum - minSum;
    }
}
// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

// First Approach 

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

// Second Approach

class Solution {
    public int maxScore(int[] cards, int k) {
        int n = cards.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cards[i];
        }

        int max = sum;
        for (int i = 1; i <= k; i++) {
            sum -= cards[k - i];
            sum += cards[n - i];
            max = Math.max(max, sum);
        }

        return max;
    }
}
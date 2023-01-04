// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/

class Solution {
  private static final int limit = 100001;
  private static final int[] dp = new int[limit];

  static {
    dp[1] = -1;
    dp[2] = 1;
    dp[3] = 1;
    dp[4] = 2;
    for (int i = 5; i < limit; i++) {
      dp[i] = Math.min(dp[i - 3], dp[i - 2]) + 1;
    }
  }

  public int minimumRounds(int[] tasks) {
    Map<Integer, Integer> count = new HashMap<>();
    for (int task : tasks) {
      count.merge(task, 1, Integer::sum);
    }

    int result = 0;
    for (int frequency : count.values()) {
      if (frequency == 1) {
        return -1;
      }
      result += dp[frequency];
    }

    return result;
  }
}

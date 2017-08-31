/**
 * https://leetcode.com/problems/split-array-largest-sum/
 */
public class SplitArrayLargestSum {
  private final int NO_RESULT = -1;
  public int splitArray(int[] nums, int m) {
    if (nums == null || nums.length == 0 || m <= 0) {
      return NO_RESULT;
    }

    long[] sum = new long[nums.length];
    sum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      sum[i] = sum[i - 1] + nums[i];
    }

    long[][] dp = new long[nums.length][m + 1];

    for (int i = 0; i < nums.length; i++) {
      for (int k = 0; k <= m; k++) {
        if (k == 0 || k > i + 1) {
          dp[i][k] = NO_RESULT;
        } else if (k == 1) {
          dp[i][k] = sum[i];
        } else {
          dp[i][k] = NO_RESULT;
          long min = Long.MAX_VALUE;
          for (int j = 0; j < i; j++) {
            if (dp[j][k - 1] != NO_RESULT) {
              long temp = Math.max(dp[j][k - 1], sum[i] - sum[j]);
              min = Math.min(min, temp);
            }
          }
          if (min != Long.MAX_VALUE) {
            dp[i][k] = min;
          }
        }
      }
    }

    return (int)dp[nums.length - 1][m];
  }
}

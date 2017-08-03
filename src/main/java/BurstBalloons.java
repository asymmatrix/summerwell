/**
 * https://leetcode.com/problems/burst-balloons/
 */
public class BurstBalloons {
  public int maxCoins(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[][] dp = new int[nums.length][nums.length + 1];

    for (int len = 1; len <= nums.length; len++) {
      for (int start = 0; start + len <= nums.length; start++) {
        int surrounding = safeGetNumber(nums, start - 1) *  safeGetNumber(nums, start + len);
        int max = -1;
        for (int lastPick = start; lastPick < start + len; lastPick++) {

          int left = (lastPick == start) ? 0 : dp[start][lastPick - start];

          int right = (lastPick == start + len - 1) ? 0 : dp[lastPick + 1][start + len - lastPick - 1];

          int val = left + surrounding * nums[lastPick] + right;
          max = Math.max(max, val);
        }
        dp[start][len] = max;
      }
    }

    return dp[0][nums.length];
  }

  static private int safeGetNumber(int[] nums, int index) {
    if (0 <= index && index < nums.length) {
      return nums[index];
    }
    return 1;
  }
}

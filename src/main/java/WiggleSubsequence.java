/**
 * https://leetcode.com/problems/wiggle-subsequence/
 */

public class WiggleSubsequence {
  public int wiggleMaxLength(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int dir = 0;
    int count = 1;
    for(int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        if (dir <= 0) {
          count++;
        }
        dir = 1;
      } else if (nums[i] < nums[i - 1]) {
        if (dir >= 0) {
          count++;
        }
        dir = -1;
      }
    }

    return count;
  }
}

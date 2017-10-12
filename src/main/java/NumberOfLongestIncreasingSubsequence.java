/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 */
public class NumberOfLongestIncreasingSubsequence {
  public int findNumberOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int lisLen[] = new int[nums.length];
    int lisCnt[] = new int[nums.length];

    lisLen[0] = 1;
    lisCnt[0] = 1;

    for(int i = 1; i < nums.length; i++) {
      int len = 1;
      int cnt = 1;

      for(int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          int tempLen = lisLen[j] + 1;
          if (tempLen == len) {
            cnt += lisCnt[j];
          } else if (tempLen > len) {
            len = tempLen;
            cnt = lisCnt[j];
          }
        }
      }

      lisLen[i] = len;
      lisCnt[i] = cnt;
    }

    int maxLen = 1;
    int count = 0;

    for(int i = 0; i < lisLen.length; i++) {
      if (lisLen[i] == maxLen) count += lisCnt[i];
      else if (lisLen[i] > maxLen) {
        maxLen = lisLen[i];
        count = lisCnt[i];
      }
    }

    return count;
  }
}

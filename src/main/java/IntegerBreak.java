/**
 * https://leetcode.com/problems/integer-break/
 */
public class IntegerBreak {
  public int integerBreak(int n) {
    if (n < 2 || n > 58) {
      return -1;
    }

    int[] maxVal = new int[n + 1];

    for (int i = 2; i <= n; i++) {
      for (int x = 1; i - x > 0; x++) {
        int val = Math.max((i - x) * x, maxVal[i - x] * x);
        maxVal[i] = Math.max(maxVal[i], val);
      }
    }

    return maxVal[n];
  }
}

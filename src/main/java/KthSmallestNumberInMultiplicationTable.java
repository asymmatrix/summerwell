/**
 * https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
 */
public class KthSmallestNumberInMultiplicationTable {
  public int findKthNumber(int m, int n, int k) {
    int lo = 1;
    int hi = m * n;

    while(lo < hi) {
      int mid = (lo + hi) / 2;
      if (!isLarger(mid, m, n, k)) lo = mid + 1;
      else hi = mid;
    }

    return lo;
  }

  // return true there're K or more elements that are <= x;
  private boolean isLarger(int x, int m, int n, int k) {
    int count = 0;

    for(int i = 1; i <= m; i++) {
      count += Math.min(x / i, n);
    }

    return count >= k;
  }
}

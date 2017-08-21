/**
 * https://leetcode.com/problems/h-index-ii/
 */
public class HIndexII {
  public int hIndex(int[] citationsAscending) {
    if (citationsAscending == null || citationsAscending.length == 0) {
      return 0;
    }

    int lo = 0, hi = citationsAscending.length;

    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if (citationsAscending[mid] >= citationsAscending.length - mid) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }

    if (lo >= citationsAscending.length) {
      return 0;
    } else if (citationsAscending[lo] >= citationsAscending.length - lo) {
      return citationsAscending.length - lo;
    } else {
      return citationsAscending.length - lo - 1;
    }
  }
}

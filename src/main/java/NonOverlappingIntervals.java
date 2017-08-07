import java.util.Arrays;
import java.util.Comparator;


/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
public class NonOverlappingIntervals {
  public int eraseOverlapIntervals(Interval[] intervals) {
    if (intervals == null || intervals.length <= 1) {
      return 0;
    }

    SortComparator sortComparator = new SortComparator();
    SearchComparator searchComparator = new SearchComparator();
    Arrays.sort(intervals, sortComparator);

    int dp[] = new int[intervals.length + 1];
    for(int i = intervals.length - 2; i >= 0; i--) {
      int ret = Arrays.binarySearch(intervals, i + 1, intervals.length, intervals[i], searchComparator);
      int nextNoneOverlapingIndex  = ret > 0 ? ret : -ret - 1;
      dp[i] = Math.min(dp[i + 1] + 1, dp[nextNoneOverlapingIndex] + nextNoneOverlapingIndex - i - 1);
    }
    return dp[0];
  }

  private class SortComparator implements Comparator<Interval> {
    public int compare(Interval o1, Interval o2) {
      if (o1.start < o2.start) return -1;
      if (o1.start > o2.start) return 1;
      if (o1.end < o2.end) return -1;
      if (o1.end > o2.end) return 1;
      return 0;
    }
  }

  private class SearchComparator implements Comparator<Interval> {
    public int compare(Interval mid, Interval key) {
      if (mid.start < key.end) return -1;
      if (mid.start > key.end) return 1;
      return 0;
    }
  }
}

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;


/**
 * https://leetcode.com/problems/find-right-interval/
 */
public class FindRightInterval {
  public int[] findRightInterval(Interval[] intervals) {
    if (intervals == null) {
      return null;
    }

    int[] result = new int[intervals.length];

    NavigableMap<Integer, Integer> map = new TreeMap<>();

    for (int i = 0; i < intervals.length; i++) {
      map.put(intervals[i].start, i);
    }

    for (int i = 0; i < intervals.length; i++) {
      Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
      result[i] = entry == null ? -1 : entry.getValue();
    }

    return result;
  }
}

import java.util.HashMap;
import java.util.TreeSet;


/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 */
public class MaximumLengthOfPairChain {
  public int findLongestChain(int[][] pairs) {
    if (pairs == null || pairs.length == 0) return 0;

    HashMap<Integer, Integer> pairMap = new HashMap<>();
    TreeSet<Integer> sortedEnd = new TreeSet<>();
    for(int[] pair : pairs) {
      int start = pair[0];
      int end = pair[1];
      sortedEnd.add(end);
      if (!pairMap.containsKey(end) || pairMap.get(end) < start) {
        pairMap.put(end, start);
      }
    }

    HashMap<Integer, Integer> lenMap = new HashMap<>();

    int prevVal = 0;
    for(int end : sortedEnd) {
      int start = pairMap.get(end);
      Integer lowerEnd = sortedEnd.lower(start);
      int temp = lowerEnd == null ? 0 : lenMap.get(lowerEnd);
      int val = Math.max(prevVal, temp + 1);

      lenMap.put(end, val);
      prevVal = val;
    }

    return lenMap.get(sortedEnd.last());
  }
}

import java.util.Collections;
import java.util.Vector;


/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Vector<Integer> activeLen = new Vector<>(nums.length);
    Vector<Integer> activeTop = new Vector<>(nums.length);

    for(int n : nums) {
      if (activeLen.isEmpty()) {
        activeLen.add(1);
        activeTop.add(n);
        continue;
      }

      if (n > activeTop.lastElement()) {
        activeLen.add(activeLen.lastElement() + 1);
        activeTop.add(n);
      }

      int searchRet = Collections.binarySearch(activeTop, n);
      if (searchRet < 0) {
        int insertion_point = -searchRet - 1;
        activeTop.set(insertion_point, n);
      }
    }

    return activeLen.lastElement();
  }
}

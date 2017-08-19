import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;


/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 */
public class RussianDollEnvelopes {
  public int maxEnvelopes(int[][] envelopes) {
    if (envelopes == null || envelopes.length == 0) {
      return 0;
    }

    Arrays.sort(envelopes, (int[] a, int[] b) -> {
      if (a[0] < b[0]) return -1;
      if (a[0] > b[0]) return 1;
      if (a[1] < b[1]) return 1;
      if (a[1] > b[1]) return -1;
      return 0;
    });

    int[] nums = new int[envelopes.length];
    for (int i = 0; i < envelopes.length; i++) {
      nums[i] = envelopes[i][1];
    }

    return lengthOfLIS(nums);
  }

  private int lengthOfLIS(int[] nums) {
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

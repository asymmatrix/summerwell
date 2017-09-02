/**
 * https://leetcode.com/problems/count-of-range-sum/
 */
public class CountRangeSum {
  public int countRangeSum(int[] nums, int lower, int upper) {
    if (nums == null || nums.length == 0 || lower > upper) {
      return 0;
    }

    long[] sums = new long[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      sums[i + 1] = sums[i] + nums[i];
    }

    return mergeSort(sums, 0, sums.length, lower, upper);
  }

  private int mergeSort(long[] sums, int start, int len, int lower, int upper) {
    if (len <= 1) return 0;

    int leftLen = len / 2;
    int rightLen = len - leftLen;
    int count = mergeSort(sums, start, leftLen, lower, upper) +
                mergeSort(sums, start + leftLen, rightLen, lower, upper);

    // count
    {
      int iLeft = start;
      int lo = start + leftLen;
      int hi = start + leftLen;

      for(; iLeft < start + leftLen; iLeft++) {

        while(lo < start + len && sums[lo] - sums[iLeft] < lower) {
          lo++;
        }

        while(hi < start + len && sums[hi] - sums[iLeft] <= upper) {
          hi++;
        }

        count += hi - lo;
      }
    }

    // sort
    {
      int iLeft = start;
      int iRight = start + leftLen;
      long[] buff = new long[len];
      int cursor = 0;
      while (iLeft < start + leftLen && iRight < start + len) {
        if (sums[iLeft] < sums[iRight]) {
          buff[cursor++] = sums[iLeft++];
        } else {
          buff[cursor++] = sums[iRight++];
        }
      }
      while (iLeft < start + leftLen) {
        buff[cursor++] = sums[iLeft++];
      }
      while (iRight < start + len) {
        buff[cursor++] = sums[iRight++];
      }
      System.arraycopy(buff, 0, sums, start, len);
    }


    return count;
  }

  private boolean inRange(int v, int lower, int upper) {
    return v >= lower && v <= upper;
  }
}

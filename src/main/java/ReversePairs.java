/**
 * https://leetcode.com/problems/reverse-pairs/
 */
public class ReversePairs {
  public int reversePairs(int[] nums) {
    if (nums == null || nums.length < 2) {
      return 0;
    }

    return mergeSort(nums, 0, nums.length);
  }

  private int mergeSort(int[] nums, int start, int len) {
    if (len <= 1) {
      return 0;
    }

    int leftLen = len / 2;
    int rightLen = len - leftLen;
    int leftCnt = mergeSort(nums, start, leftLen);
    int rightCnt = mergeSort(nums, start + leftLen, rightLen);
    int count = 0;

    // count
    {
      int iLeft = start;
      int iRight = start + leftLen;
      while (iLeft < start + leftLen && iRight < start + len) {
        if ((long)nums[iLeft] > (long)nums[iRight] * 2L) {
          iRight++;
          count += start + leftLen - iLeft;
        } else {
          iLeft++;
        }
      }
    }

    // sort
    {
      int[] buff = new int[len];
      int cursor = 0;
      int iLeft = start;
      int iRight = start + leftLen;
      while (iLeft < start + leftLen && iRight < start + len) {
        if (nums[iLeft] < nums[iRight]) {
          buff[cursor++] = nums[iLeft++];
        } else {
          buff[cursor++] = nums[iRight++];
        }
      }
      while (iLeft < start + leftLen) {
        buff[cursor++] = nums[iLeft++];
      }
      while (iRight < start + len) {
        buff[cursor++] = nums[iRight++];
      }

      System.arraycopy(buff, 0, nums, start, len);
    }

    return leftCnt + rightCnt + count;
  }
}

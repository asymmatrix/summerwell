/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class SingleElementInSortedArray {
  public int singleNonDuplicate(int[] nums) {
    if (nums == null || nums.length < 1) {
      return -1;
    }

    if (nums.length == 1) {
      return nums[0];
    }

    int lo = 0;
    int hi = nums.length - 1;

    while(lo < hi) {
      int mid = (lo + hi) / 2;
      if (isUniqueNumber(nums, mid)) {
        return nums[mid];
      }
      if (isUniqueNumber(nums, lo)) {
        return nums[lo];
      }
      if (isUniqueNumber(nums, hi)) {
        return nums[hi];
      }

      if (mid > 0 && nums[mid] == nums[mid - 1]) {
        if (mid % 2 == 1) {
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      } else {
        if (mid % 2 == 1) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      }
    }

    return -1;
  }

  private boolean isUniqueNumber(int[] nums, int i) {
    return (i == 0 || nums[i] != nums[i - 1]) && (i == nums.length - 1 || nums[i] != nums[i + 1]);
  }
}

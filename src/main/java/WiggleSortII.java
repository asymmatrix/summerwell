/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 */
public class WiggleSortII {
  public void wiggleSort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    int len = nums.length;
    int medianIndex = len / 2 + len % 2;
    nthSort(nums, 0, len - 1, medianIndex);

    int median = nums[medianIndex];
    int n = nums.length;
    int left = 0, i = 0, right = n - 1;

    while (i <= right) {

      if (nums[newIndex(i,n)] > median) {
        swap(nums, newIndex(left++,n), newIndex(i++,n));
      }
      else if (nums[newIndex(i,n)] < median) {
        swap(nums, newIndex(right--,n), newIndex(i,n));
      }
      else {
        i++;
      }
    }
  }

  private int newIndex(int index, int n) {
    return (1 + 2*index) % (n | 1);
  }

  private void nthSort(int[] nums, int start, int end, int n) {
    if (start >= end) return;

    int idx = partition(nums, start, end);

    if (idx == n) return;
    if (idx < n) nthSort(nums, idx + 1, end, n);
    else nthSort(nums, start, idx - 1, n);
  }

  private int partition(int[] nums, int start, int end) {
    int pivot = nums[end];
    int i = start;
    for (int j = start; j < end; j++) {
      if (nums[j] <= pivot) {
        swap(nums, i++, j);
      }
    }
    swap(nums, i, end);
    return i;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

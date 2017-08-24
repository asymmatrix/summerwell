/**
 * https://leetcode.com/problems/patching-array/
 */
public class PatchingArray {
  public int minPatches(int[] nums, int n) {
    if (n <= 0) {
      return 0;
    }

    long target = 1;
    int i = 0;
    int patchCount = 0;
    while(target <= n && nums != null && i < nums.length) {
      if (nums[i] < target) {
        target += nums[i];
        i++;
      } else if (nums[i] == target) {
        i++;
        target *= 2;
      } else {
        patchCount++;
        target *= 2;
      }
    }

    while (target <= n) {
      patchCount++;
      target *= 2;
    }

    return patchCount;
  }
}

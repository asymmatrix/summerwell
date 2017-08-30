/**
 * https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {
  public int firstMissingPositive(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
      int v = nums[i];
      nums[i] = -1;

      while(1 <= v && v <= nums.length && nums[v - 1] != v) {
        int x = nums[v - 1];
        nums[v-1] = v;
        v = x;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }

    return nums.length + 1;
  }
}

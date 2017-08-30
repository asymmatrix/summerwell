/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindDuplicateNumber {
  private final int NO_RESULT = -1;

  public int findDuplicate(int[] nums) {
    if (nums == null || nums.length < 2) {
      return NO_RESULT;
    }

    int fast = nums[nums[0]], slow = nums[0];

    while(fast != slow) {
      fast = nums[nums[fast]];
      slow = nums[slow];
    }

    slow = 0;
    while(fast != slow) {
      fast = nums[fast];
      slow = nums[slow];
    }

    return slow;
  }
}

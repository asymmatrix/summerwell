/**
 * https://leetcode.com/problems/array-nesting/
 */
public class ArrayNesting {
  public int arrayNesting(int[] nums) {
    int answer = 0;
    for (int i = 0; i < nums.length; i++) {
      if (!visited(nums, i)) {
        int temp = find(nums, i);
        answer = Math.max(temp, answer);
      }
    }
    return answer;
  }

  private int find(int[] nums, int i) {
    int count = 0;
    while(!visited(nums, i)) {
      int next = nums[i];
      count++;
      markVisited(nums, i);
      i = next;
    }
    return count;
  }


  private void markVisited(int[] nums, int i) {
    nums[i] = nums[i] | (1 << 30);
  }

  private boolean visited(int[] nums, int i) {
    return (nums[i] & (1 << 30)) != 0;
  }
}

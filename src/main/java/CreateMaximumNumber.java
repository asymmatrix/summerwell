/**
 * https://leetcode.com/problems/create-maximum-number/
 */
public class CreateMaximumNumber {
  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int[] answer = new int[k];
    for(int i = 0; i <= k; i++) {
      if (i <= nums1.length && k - i <= nums2.length) {
        int[] maxNum1 = createMaxnumberFromOneArray(nums1, i);
        int[] maxNum2 = createMaxnumberFromOneArray(nums2, k - i);
        int[] temp = merge(maxNum1, maxNum2);
        if (greater(temp, 0, answer, 0)) answer = temp;
      }
    }
    return answer;
  }

  private boolean greater(int[] nums1, int start1, int[] nums2, int start2) {
    while(start1 < nums1.length && start2 < nums2.length && nums1[start1] == nums2[start2]) {
      start1++;
      start2++;
    }

    return start2 == nums2.length || start1 < nums1.length && nums1[start1] > nums2[start2];
  }

  private int[] merge(int[] nums1, int[] nums2) {
    int[] answer = new int[nums1.length + nums2.length];
    int iAns = 0;
    int i1 = 0;
    int i2 = 0;
    while(i1 < nums1.length && i2 < nums2.length) {
      answer[iAns++] = greater(nums1, i1, nums2, i2) ? nums1[i1++] : nums2[i2++];
    }
    while(i1 < nums1.length) answer[iAns++] = nums1[i1++];
    while(i2 < nums2.length) answer[iAns++] = nums2[i2++];

    return answer;
  }

  private int[] createMaxnumberFromOneArray(int[] nums, int k) {
    int[] answer = new int[k];
    int cursor = 0;
    int start = 0;

    while(cursor < k) {
      int maxIdx = start;
      for (int i = start; i <= nums.length - k + cursor; i++) {
        if (nums[i] > nums[maxIdx]) {
          maxIdx = i;
        }
      }

      answer[cursor++] = nums[maxIdx];
      start = maxIdx + 1;
    }

    return answer;
  }
}

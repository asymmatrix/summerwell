/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if ((nums1.length + nums2.length) % 2 == 1) {
      return findKth(nums1, nums2, (nums1.length + nums2.length + 1) / 2);
    } else {
      double a = findKth(nums1, nums2, (nums1.length + nums2.length) / 2);
      double b = findKth(nums1, nums2, (nums1.length + nums2.length) / 2 + 1);
      return (a + b) / 2.0;
    }
  }

  public int findKth(int[] A, int[] B, int k) {
    if (k >= A.length + B.length) {
      if (A.length == 0) return B[B.length - 1];
      else if (B.length == 0) return A[A.length - 1];
      return Math.max(A[A.length - 1], B[B.length - 1]);
    }

    if (A.length == 0) return B[k - 1];
    if (B.length == 0) return A[k - 1];

    if (A.length > B.length) {
      int[] temp = A; A = B; B = temp;
    }

    int start = 0;
    int end = Math.min(k, A.length);

    while(start <= end) {
      int ia = (start + end) / 2;
      int ib = k - ia - 2;

      if (ib + 1 < B.length && A[ia] > B[ib + 1]) {
        end = ia - 1;
      } else if (ib >= 0 && ia + 1 < A.length && B[ib] > A[ia + 1] ) {
        start = ia + 1;
      } else {
        if (ia < 0) return B[ib];
        else if (ib < 0) return A[ia];
        return Math.max(A[ia], B[ib]);
      }
    }

    return B[k - 1];
  }
}

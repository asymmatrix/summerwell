import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 */
public class FindKClosestElements {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    LinkedList<Integer> answer = new LinkedList<>();

    if (arr == null || arr.length == 0 || k <= 0) {
      return answer;
    }

    int right = bsearch_gt(arr, x);
    int left = right - 1;

    while(left >= 0 && right < arr.length && answer.size() < k) {
      int dist_left = x - arr[left];
      int dist_right = arr[right] - x;

      if (dist_left <= dist_right) {
        answer.addFirst(arr[left--]);
      } else {
        answer.addLast(arr[right++]);
      }
    }

    while(left >= 0 && answer.size() < k) answer.addFirst(arr[left--]);
    while(right < arr.length && answer.size() < k ) answer.addLast(arr[right++]);

    return answer;
  }

  private int bsearch_gt(int[] arr, int x) {
    if (x <= arr[0]) return 0;
    if (x > arr[arr.length - 1]) return arr.length;
    if (x == arr[arr.length - 1]) return arr.length - 1;

    int start = 1, end = arr.length - 2;
    while(start <= end) {
      int mid = (start + end) / 2;
      if (arr[mid - 1] < x && x <= arr[mid]) return mid;
      else if (x <= arr[mid - 1]) end = mid - 1;
      else start = mid + 1;
    }

    return start;
  }
}

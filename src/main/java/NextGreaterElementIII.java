import java.util.ArrayList;
import java.util.Collections;


/**
 * https://leetcode.com/problems/next-greater-element-iii/
 */
public class NextGreaterElementIII {
  public int nextGreaterElement(int n) {
    int[] arr = toArray(n);
    if (!changeToNext(arr)) return -1;
    long result = fromArray(arr);
    return result > Integer.MAX_VALUE ? -1 : (int)result;
  }

  private int[] toArray(int n) {
    ArrayList<Integer> list = new ArrayList<>();
    while(n != 0) {
      list.add(n % 10);
      n /= 10;
    }
    if (list.size() == 0) {
      list.add(0);
    }
    Collections.reverse(list);
    return list.stream().mapToInt(i->i).toArray();
  }

  private long fromArray(int[] arr) {
    long n = 0;
    for(int x : arr) {
      n = n * 10 + (long)x;
    }
    return n;
  }

  private boolean changeToNext(int[] arr) {

    // find last descding segment
    int last_desceding_start = -1;
    for (int i = arr.length - 1; i > 0; i--) {
      if (arr[i] > arr[i - 1]) {
        last_desceding_start = i;
        break;
      }
    }
    if (last_desceding_start <= 0) return false;

    // find the smallest element in the desceding segment which is greater than arr[last_desceding_start - 1]
    int min_larger_index = last_desceding_start;
    for(int i = arr.length - 1; i >= last_desceding_start; i--) {
      if (arr[i] > arr[last_desceding_start - 1]) {
        min_larger_index = i;
        break;
      }
    }

    // swap and reverse
    swap(arr, last_desceding_start - 1, min_larger_index);
    reverse(arr, last_desceding_start, arr.length - 1);

    return true;
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private void reverse(int[] arr, int start, int end) {
    while(start < end) {
      swap(arr, start++, end--);
    }
  }
}

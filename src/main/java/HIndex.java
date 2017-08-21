/**
 * https://leetcode.com/problems/h-index/
 */
public class HIndex {
  public int hIndex(int[] citations) {
    if (citations == null || citations.length == 0) {
      return 0;
    }
    return qsort(citations, 0, citations.length);
  }

  public int qsort(int[] citations, int start, int end) {
    if (start == end - 1) {
      if (citations[start] > start) {
        return start + 1;
      } else {
        return start;
      }
    }

    int mark = citations[start];
    int lo = start + 1;
    int hi = end - 1;
    while(lo < hi) {
      while(lo < hi && citations[lo] >= mark) lo++;
      while(lo < hi && citations[hi] < mark) hi--;
      if (lo < hi) {
        swap(citations, lo, hi);
      }
    }
    if (citations[start] < citations[lo]) {
      swap(citations, start, lo);
    }

    if (mark > lo) {
      return qsort(citations, lo, end);
    } else {
      return qsort(citations, start, lo);
    }
  }

  private void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}

import java.util.TreeMap;


/**
 * https://leetcode.com/problems/sliding-window-median/
 */
public class SlidingWindowMedian {
  public double[] medianSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
      return new double[] {};
    }

    int cursor = 0;
    double[] answer = new double [nums.length - k + 1];

    MedianFinder mediaFinder = new MedianFinder();

    for (int i = 0; i < nums.length; i++) {
      mediaFinder.add(nums[i]);

      if ( i >= k - 1) {
        int removeIndex = i - k;
        if (removeIndex >= 0) {
          mediaFinder.remove(nums[removeIndex]);
        }
        answer[cursor++] = mediaFinder.median();
      }
    }

    return answer;
  }

  private class MedianFinder {
    private MultiTreeSet<Integer> smallHalf = new MultiTreeSet<>();
    private MultiTreeSet<Integer> largeHalf = new MultiTreeSet<>();

    void add(int n) {
      if (largeHalf.size() == 0 ||
          n >= largeHalf.first()) {
        largeHalf.add(n);
      } else {
        smallHalf.add(n);
      }
      adjust();
    }

    void remove(int n) {
      boolean removed = largeHalf.remove(n);
      if (!removed) {
        smallHalf.remove(n);
      }
      adjust();
    }

    double median() {
      if (largeHalf.size() > smallHalf.size()) {
        return largeHalf.first();
      } else {
        return ((double)smallHalf.last() + (double)largeHalf.first()) / 2.0;
      }
    }

    private void adjust() {
      while (largeHalf.size() > smallHalf.size() + 1) {
        int first = largeHalf.first();
        largeHalf.remove(first);
        smallHalf.add(first);
      }

      while (largeHalf.size() < smallHalf.size()) {
        int last = smallHalf.last();
        smallHalf.remove(last);
        largeHalf.add(last);
      }
    }
  }

  private class MultiTreeSet<T> {
    private TreeMap<T, Integer> treeMap = new TreeMap<>();
    private int count = 0;

    void add(T elem) {
      count++;
      treeMap.put(elem, treeMap.getOrDefault(elem, 0) + 1);
    }

    boolean remove(T elem) {
      if (!treeMap.containsKey(elem)) {
        return false;
      }

      count--;
      int newCount = treeMap.get(elem) - 1;
      if (newCount == 0) {
        treeMap.remove(elem);
      } else {
        treeMap.put(elem, newCount);
      }

      return true;
    }

    int size() {
      return count;
    }

    T first() {
      return treeMap.firstKey();
    }

    T last() {
      return treeMap.lastKey();
    }
  }

}

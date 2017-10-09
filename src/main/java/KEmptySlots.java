import java.util.ArrayDeque;
import java.util.Queue;


/**
 * https://leetcode.com/problems/k-empty-slots/
 */
public class KEmptySlots {
  public int kEmptySlots(int[] flowers, int k) {
    if (flowers == null || flowers.length == 0 || k < 0) {
      return -1;
    }

    int[] days = new int[flowers.length];
    for(int i = 0; i < flowers.length; i++) {
      days[flowers[i] - 1] = i + 1;
    }

    MinQueue mq = new MinQueue();
    int ans = Integer.MAX_VALUE;
    for(int i = 0; i < days.length; i++) {
      mq.offer(days[i]);
      if (i >= k && i < days.length - 1) {
        mq.poll();
        if (k == 0 || mq.min() > days[i - k] && mq.min() > days[i + 1]) {
          ans = Math.min(ans, Math.max(days[i - k], days[i + 1]));
        }
      }
    }

    return ans == Integer.MAX_VALUE ? -1 : ans;
  }

  private class MinQueue {
    Queue<Integer> all_elements = new ArrayDeque<>();
    ArrayDeque<Integer> min_cadidates = new ArrayDeque<>();

    void offer(int x) {
      all_elements.offer(x);
      while(!min_cadidates.isEmpty()) {
        if (min_cadidates.peekLast() > x) {
          min_cadidates.pollLast();
        } else {
          break;
        }
      }
      min_cadidates.offer(x);
    }

    int poll() {
      int elem = all_elements.poll();
      if (elem == min_cadidates.peek()) {
        min_cadidates.poll();
      }
      return elem;
    }

    int min() {
      return min_cadidates.peek();
    }
  }
}

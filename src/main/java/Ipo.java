import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;


/**
 * https://leetcode.com/problems/ipo/
 */
public class Ipo {
  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    if (k == 0 || profits == null || profits.length == 0 || capital == null || capital.length == 0 || profits.length != capital.length) {
      return w;
    }

    Integer[] idx = new Integer[profits.length];
    for(int i = 0; i < idx.length; i++) {
      idx[i] = i;
    }

    Arrays.sort(idx, (Integer a, Integer b) -> capital[a] - capital[b]);

    PriorityQueue<Integer> pq = new PriorityQueue<>(100, Collections.reverseOrder());

    int maxSoFar = w;
    int cursor = 0;
    for (int t = 0; t < k; t++) {
      while(cursor < idx.length && capital[idx[cursor]] <= maxSoFar) {
        pq.offer(profits[idx[cursor]]);
        cursor++;
      }

      if (pq.isEmpty()) break;
      maxSoFar += pq.poll();
    }

    return maxSoFar;
  }
}

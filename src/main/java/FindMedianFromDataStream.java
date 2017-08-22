import java.util.Collections;
import java.util.PriorityQueue;


/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class FindMedianFromDataStream {
  class MedianFinder {

    PriorityQueue<Integer> smallHalf_maxHeap = new PriorityQueue<>(100, Collections.reverseOrder());
    PriorityQueue<Integer> largeHalf_minHeap = new PriorityQueue<>();

    public MedianFinder() {
    }

    public void addNum(int num) {
      largeHalf_minHeap.offer(num);
      smallHalf_maxHeap.offer(largeHalf_minHeap.poll());
      if (largeHalf_minHeap.size() < smallHalf_maxHeap.size()) {
        largeHalf_minHeap.offer(smallHalf_maxHeap.poll());
      }
    }

    public double findMedian() {
      if (largeHalf_minHeap.isEmpty() && smallHalf_maxHeap.isEmpty()) {
        return 0;
      }

      if (largeHalf_minHeap.size() > smallHalf_maxHeap.size()) {
        return largeHalf_minHeap.peek();
      } else {
        return (smallHalf_maxHeap.peek() + largeHalf_minHeap.peek()) / 2.0f;
      }
    }
  }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
  public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> result = new ArrayList<>();

    if (nums == null || nums.length == 0 || k <= 0) {
      return result;
    }

    Map<Integer, Integer> num_freq = new HashMap<>();
    for(int n : nums) {
      num_freq.put(n, num_freq.getOrDefault(n, 0) + 1);
    }

    List<Integer>[] freq_nums = new List[nums.length + 1];

    for (int num: num_freq.keySet()) {
      int freq = num_freq.get(num);
      if (freq_nums[freq] == null) {
        freq_nums[freq] = new ArrayList<>();
      }
      freq_nums[freq].add(num);
    }

    for(int f = nums.length; f > 0 && result.size() < k; f--) {
      if (freq_nums[f] != null) {
        result.addAll(freq_nums[f]);
      }
    }

    return result.size() > k ? result.subList(0, k) : result;
  }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * https://leetcode.com/problems/increasing-subsequences/
 */
public class IncreasingSubsequences {
  public List<List<Integer>> findSubsequences(int[] nums) {
    TreeMap<Integer, HashSet<String>> map = new TreeMap<>();

    for(int n : nums) {
      if (!map.containsKey(n)) {
        map.put(n, new HashSet<>());
      }
      HashSet<String> newSet = new HashSet<>();
      for(Map.Entry<Integer, HashSet<String>> entry : map.entrySet()) {
        if (entry.getKey() > n) break;
        HashSet<String> newLists = extend(entry.getValue(), n);
        newSet.addAll(newLists);
      }
      map.put(n, newSet);
    }

    return deserialize(map);
  }


  private HashSet<String>  extend(HashSet<String> input, int n) {
    HashSet<String> result = new HashSet<>();

    String n_str = String.valueOf(n);
    for(String str: input) {
      result.add(str + "," + n_str);
    }

    result.add(n_str);

    return result;
  }

  private List<Integer> deserialize(String str) {
    List<Integer> answer = new ArrayList<>();
    String[] arr = str.split(",");
    for(String s : arr) {
      answer.add(Integer.parseInt(s));
    }
    return answer;
  }

  private List<List<Integer>> deserialize(TreeMap<Integer, HashSet<String>> map) {

    List<List<Integer>> answer = new ArrayList<>();
    for(Map.Entry<Integer, HashSet<String>> entry : map.entrySet()) {
      for (String str : entry.getValue()) {
        List<Integer> temp = deserialize(str);
        if (temp.size() >= 2) {
          answer.add(temp);
        }
      }
    }
    return answer;
  }
}

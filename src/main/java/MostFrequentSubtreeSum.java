import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 */
public class MostFrequentSubtreeSum {
  public int[] findFrequentTreeSum(TreeNode root) {
    if (root == null) {
      return new int[] {};
    }

    MaxFreqFinder<Integer> finder = new MaxFreqFinder<>();
    findRecursivelly(root, finder);
    Set<Integer> result = finder.maxFreq();
    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  private int findRecursivelly(TreeNode root, MaxFreqFinder<Integer> finder) {
    if (root == null) {
      return 0;
    }

    int sum = findRecursivelly(root.left, finder) + root.val +
              findRecursivelly(root.right, finder);
    finder.add(sum);
    return sum;
  }

  private class MaxFreqFinder<T> {
    private HashMap<Integer, HashSet<T>> freqToVals = new HashMap<>();
    private HashMap<T, Integer> valToFreq = new HashMap<>();
    private int maxFreq = 0;

    public void add (T element) {
      int oldFreq = valToFreq.getOrDefault(element, 0);
      int newFreq = oldFreq + 1;
      removeFromFreqMap(oldFreq, element);
      addToFreqMap(newFreq, element);
      valToFreq.put(element, newFreq);
      maxFreq = Math.max(maxFreq, newFreq);
    }

    public Set<T> maxFreq() {
      return freqToVals.getOrDefault(maxFreq, new HashSet<>());
    }

    private void addToFreqMap(int freq, T element) {
      if (!freqToVals.containsKey(freq)) {
        freqToVals.put(freq, new HashSet<>());
      }
      freqToVals.get(freq).add(element);
    }

    private void removeFromFreqMap(int freq, T element) {
      if (!freqToVals.containsKey(freq)) return;
      freqToVals.get(freq).remove(element);
    }
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
}

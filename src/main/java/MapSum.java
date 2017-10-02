import java.util.HashMap;


/**
 * https://leetcode.com/problems/map-sum-pairs/
 */
public class MapSum {

  private HashMap<String, Integer> map = new HashMap<>();
  private TrieNode trieRoot = new TrieNode(0);

  /** Initialize your data structure here. */
  public MapSum() {
  }

  public void insert(String key, int val) {
    if (key == null || key.length() == 0) {
      return;
    }

    if (map.containsKey(key)) {
      val -= map.get(key);
    }

    map.put(key, val);

    TrieNode root = trieRoot;
    root.val += val;
    for(char ch : key.toCharArray()) {
      if (!root.children.containsKey(ch)) {
        root.children.put(ch, new TrieNode(val));
      } else {
        root.children.get(ch).val += val;
      }
      root = root.children.get(ch);
    }
  }

  public int sum(String prefix) {
    if (prefix == null) {
      return 0;
    }

    if (prefix.length() == 0) {
      return trieRoot.val;
    }

    TrieNode root = trieRoot;
    for (char ch : prefix.toCharArray()) {
      if (!root.children.containsKey(ch)) {
        return 0;
      }
      root = root.children.get(ch);
    }
    return root.val;
  }

  private class TrieNode {
    int val;
    HashMap<Character, TrieNode> children = new HashMap<>();
    TrieNode(int val) {
      this.val = val;
    }
  }
}

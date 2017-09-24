import java.util.HashMap;


/**
 * https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {
  public boolean checkInclusion(String s1, String s2) {
    if (s1 == null || s1.length() == 0) return true;
    if (s2 == null || s1.length() > s2.length()) return false;

    Tracker tracker = new Tracker(s1);
    for(int i = 0; i < s1.length(); i++) {
      char ch = s2.charAt(i);
      tracker.add(ch);
    }

    if (tracker.found()) return true;

    for(int i = s1.length(); i < s2.length(); i++) {
      char chRemove = s2.charAt(i - s1.length());
      char chAdd = s2.charAt(i);
      tracker.add(chAdd);
      tracker.remove(chRemove);
      if (tracker.found()) return true;
    }

    return false;
  }

  private class Tracker {
    HashMap<Character, Integer> countMap = new HashMap<>();
    int zeroCount = 0;
    int targetZeroCount = 0;

    Tracker(String target) {
      for(char ch : target.toCharArray()) {
        countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
      }
      targetZeroCount = countMap.size();
    }

    void add(char ch) {
     doChange(ch, -1);
    }

    void remove(char ch) {
      doChange(ch, 1);
    }

    private void doChange(char ch, int delta) {
      if (!countMap.containsKey(ch)) {
        return;
      }

      int oldCount = countMap.get(ch);
      int newCount = oldCount + delta;

      if (oldCount == 0) zeroCount--;
      else if (newCount == 0) zeroCount++;

      countMap.put(ch, newCount);
    }

    boolean found() {
      return zeroCount == targetZeroCount;
    }
  }
}

import java.util.HashMap;


/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings_CharIndexMap {
  public boolean isIsomorphic(String s, String t) {
    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }

    HashMap<Character, Integer> map_s = new HashMap<>();
    HashMap<Character, Integer> map_t = new HashMap<>();

    for(int i = 0; i < s.length(); i++) {
      if (map_s.getOrDefault(s.charAt(i), -1) != map_t.getOrDefault(t.charAt(i), -1)) {
        return false;
      }
      if (!map_s.containsKey(s.charAt(i))) {
        map_s.put(s.charAt(i), i);
      }

      if (!map_t.containsKey(t.charAt(i))) {
        map_t.put(t.charAt(i), i);
      }
    }
    return true;
  }
}

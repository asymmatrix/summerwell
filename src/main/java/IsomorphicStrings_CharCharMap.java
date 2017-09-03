import java.util.HashMap;
import java.util.HashSet;


/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings_CharCharMap {
  public boolean isIsomorphic(String s, String t) {
    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }
    HashMap<Character, Character> map = new HashMap<>();
    HashSet<Character> mappedChars = new HashSet<>();

    for(int i = 0; i < s.length(); i++) {
      Character ch_s = s.charAt(i);
      Character ch_t = t.charAt(i);
      if (!map.containsKey(ch_s)) {
        if (mappedChars.contains(ch_t)) {
          return false;
        }
        map.put(ch_s, ch_t);
        mappedChars.add(ch_t);
      }
      if (map.get(ch_s) != ch_t) {
        return false;
      }
    }

    return true;
  }
}

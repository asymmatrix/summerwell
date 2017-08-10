/**
 * https://leetcode.com/problems/is-subsequence/
 * Greedy algorithm, match s[i] with t[j] where j is least.
 * prove: assume s is a subsequence of t, and s[0] == t[x]
 * if there is t[i] where i < x AND s[0] == t[i], then we can match s[0] with t[i]
 */
public class IsSubsequence {
  public boolean isSubsequence(String s, String t) {
    if (s == null || s.length() == 0) return true;
    if (t == null || t.length() < s.length()) return false;

    int si = 0;
    int ti = 0;

    while(si < s.length() && ti < t.length()) {
      if (s.charAt(si) == t.charAt(ti)) {
        si++;
      }
      ti++;
    }

    return si == s.length();
  }
}

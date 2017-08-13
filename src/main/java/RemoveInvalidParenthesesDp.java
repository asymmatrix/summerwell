import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javafx.util.Pair;


/**
 *  https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class RemoveInvalidParenthesesDp {
  public List<String> removeInvalidParentheses(String s) {
    if (s == null || s.length() == 0) {
      return Arrays.asList("");
    }

    Map<Pair<Integer, Integer>, Integer> removalCnt = new HashMap<>();
    Map<Pair<Integer, Integer>, Set<String>> answer = new HashMap<>();

    // len == 1
    for(int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '(' && s.charAt(i) != ')') {
        removalCnt.put(new Pair<>(i, 1), 0);
        answer.put(new Pair<>(i, 1), new HashSet<>(Arrays.asList(s.substring(i, i + 1))));
      } else {
        removalCnt.put(new Pair<>(i, 1), 1);
        answer.put(new Pair<>(i, 1), new HashSet<>(Arrays.asList("")));
      }
    }

    // len >= 2
    for(int len = 2; len <= s.length(); len++) {
      for (int start = 0; start + len <= s.length(); start++) {
        removalCnt.put(new Pair<>(start, len), Integer.MAX_VALUE);
        answer.put(new Pair<>(start, len), new HashSet<>());
        for (int mid = start + 1; mid <= start + len - 1; mid++) {
          int removal = removalCnt.get(new Pair<>(start, mid - start)) + removalCnt.get(new Pair<>(mid, start + len - mid));
          if (removal <= removalCnt.get(new Pair<>(start, len))) {
            Set<String> tempAns =
                cross(answer.get(new Pair<>(start, mid - start)), answer.get(new Pair<>(mid, start + len - mid)));
            if (removal < removalCnt.get(new Pair<>(start, len))) {
              removalCnt.put(new Pair<>(start, len), removal);
              answer.put(new Pair<>(start, len), tempAns);
            } else if (removal == removalCnt.get(new Pair<>(start, len))) {
              answer.get(new Pair<>(start, len)).addAll(tempAns);
            }
          }
        }

        if (s.charAt(start) == '(' && s.charAt(start + len - 1) == ')') {
          if (len == 2) {
            removalCnt.put(new Pair<>(start, len), 0);
            answer.put(new Pair<>(start, len), new HashSet<>(Arrays.asList("()")));
          } else {
            int removal = removalCnt.get(new Pair<>(start + 1, len - 2));
            if (removal <= removalCnt.get(new Pair<>(start, len))) {
              Set<String> tempAns = brace(answer.get(new Pair<>(start + 1, len - 2)));
              if (removal < removalCnt.get(new Pair<>(start, len))) {
                removalCnt.put(new Pair<>(start, len), removal);
                answer.put(new Pair<>(start, len), tempAns);
              } else {
                answer.get(new Pair<>(start, len)).addAll(tempAns);
              }
            }
          }
        }
      }
    }

    return answer.get(new Pair(0, s.length())).stream().collect(Collectors.toList());
  }

  private Set<String> cross(Set<String> list1, Set<String> list2) {
    Set<String> ans = new HashSet<>();
    for (String s1 : list1)
      for (String s2: list2) {
        if (s1.length() == 0 && s2.length() == 0) {
          ans.add("");
        } else {
          ans.add(s1 + s2);
        }
      }
    return ans;
  }

  private Set<String> brace(Set<String> list) {
    Set<String> ans = new HashSet<>();
    for (String s : list) {
      ans.add("(" + s + ")");
    }
    return ans;
  }
}

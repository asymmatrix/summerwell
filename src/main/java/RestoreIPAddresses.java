import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {
  public List<String> restoreIpAddresses(String s) {
    if (s == null) {
      return Collections.emptyList();
    }

    String current = "";
    List<String> answer = new ArrayList<>();
    restore(s, 0, 0, current, answer);

    return answer;
  }

  private void restore(String s, int start, int segIndex, String current, List<String> answer) {
    if (segIndex == 4) {
      if (start >= s.length()) {
        answer.add(current);
      }
      return;
    }

    int remainingLen = s.length() - start;
    if (remainingLen > (4 - segIndex) * 3 || remainingLen < (4 - segIndex)) {
      return;
    }

    for(int len = 1; len <= 3 && start + len <= s.length(); len++) {
      if (s.charAt(start) == '0' && len > 1) break;
      String seg = s.substring(start, start + len);
      int segAsNumber = Integer.parseInt(seg);
      if (segAsNumber <= 255) {
        restore(s, start + len, segIndex + 1, current.length() == 0 ? seg : current + "." + seg, answer);
      }
    }
  }
}

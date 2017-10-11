import java.util.HashSet;
import java.util.Set;


/**
 * https://leetcode.com/problems/next-closest-time/
 */
public class NextClosestTime {
  public String nextClosestTime(String time) {
    HashSet<Character> allowedDigits = new HashSet<>();
    for(char ch : time.toCharArray()) {
      allowedDigits.add(ch);
    }

    HourMin hm = new HourMin(time);
    while(true) {
      hm.inc();
      if (hm.checkDigits(allowedDigits)) {
        return hm.toString();
      }
    }
  }

  private class HourMin {
    private int hour, min;

    HourMin(String time) {
      String[] sp = time.split(":");
      this.hour = Integer.parseInt(sp[0]);
      this.min = Integer.parseInt(sp[1]);
    }

    public void inc() {
      this.min++;
      if (this.min >= 60) {
        this.min = 0;
        this.hour++;
        if (this.hour >= 24) {
          this.hour = 0;
        }
      }
    }

    public String toString() {
      return String.format("%02d:%02d", this.hour, this.min);
    }

    public boolean checkDigits(Set<Character> allowedDigits) {
      String str = toString();
      for(char ch : str.toCharArray()) {
        if ('0' <= ch && ch <= '9' && !allowedDigits.contains(ch)) {
          return false;
        }
      }
      return true;
    }
  }
}

import java.util.HashMap;


/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 */
public class QueueReconstructionByHeight {
  public int[][] reconstructQueue(int[][] people) {
    if (people == null || people.length == 0) {
      return people;
    }

    int[] count = new int[people.length];
    for(int i = 0; i < people.length; i++) {
      count[i] = people[i][1];
    }

    int[] order = new int[people.length];
    int cursor = 0;

    while(cursor < order.length) {
      int index = -1;
      for(int i = 0; i < count.length; i++) {
        if (count[i] == 0 && (index == -1 || people[i][0] < people[index][0])) {
          index = i;
        }
      }

      if (index == -1) return null;

      order[cursor++] = index;
      count[index] = -1;

      for(int i = 0; i < count.length; i++) {
        if (count[i] > 0 && people[index][0] >= people[i][0]) {
          count[i]--;
        }
      }
    }

    int[][] answer = new int[people.length][2];
    for(int i = 0; i < order.length; i++) {
      answer[i][0] = people[order[i]][0];
      answer[i][1] = people[order[i]][1];
    }

    return answer;
  }
}

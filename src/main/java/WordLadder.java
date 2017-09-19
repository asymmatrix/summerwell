import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.stream().anyMatch(x -> x.compareTo(endWord) == 0)) return 0;

    HashMap<String, Integer> visited_begin = new HashMap<>();
    HashMap<String, Integer> visited_end = new HashMap<>();

    Queue<String> queue_begin = new LinkedList<String>();
    Queue<String> queue_end = new LinkedList<String>();

    queue_begin.offer(beginWord);
    visited_begin.put(beginWord, 1);

    queue_end.offer(endWord);
    visited_end.put(endWord, 0);

    while(!queue_begin.isEmpty() && !queue_end.isEmpty()) {
      int ret = process(queue_begin, visited_begin, visited_end, wordList);
      if (ret > 0) return ret;
      ret = process(queue_end, visited_end, visited_begin, wordList);
      if (ret > 0) return ret;
    }

    return 0;
  }

  private int process(Queue<String> queue, HashMap<String, Integer> visited, HashMap<String, Integer> visited_other, List<String> wordList) {
    String key = queue.poll();

    for(String word: wordList) {
      if (isTransformable(key, word) && !visited.containsKey(word)) {

        if (visited_other.containsKey(word)) {
          return visited.get(key) + visited_other.get(word) + 1;
        }

        visited.put(word, visited.get(key) + 1);
        queue.offer(word);
      }
    }

    return -1;
  }

  private boolean isTransformable(String str1, String str2) {
    if (str1.length() != str2.length()) return false;

    boolean foundDiff = false;
    for(int i = 0; i < str1.length(); i++) {
      if (str1.charAt(i) != str2.charAt(i)) {
        if (foundDiff) return false;
        foundDiff = true;
      }
    }

    return true;
  }
}

import java.util.HashMap;
import java.util.HashSet;


/**
 * https://leetcode.com/problems/evaluate-division/
 */
public class EvaluateDivision {
  private final double NO_ANSWER = -1.0D;
  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    HashMap<String, HashMap<String, Double>> map = new HashMap<>();
    HashSet<String> zero = new HashSet<>();

    for(int i = 0; i < equations.length; i++) {
      String a = equations[i][0];
      String b = equations[i][1];
      double val = values[i];
      if (val == 0.0D) {
        zero.add(a);
      } else {
        addEdge(map, a, b, val);
        addEdge(map, b, a, 1.0D / val);
      }
    }

    for(String k : map.keySet()) {
      for(String i : map.keySet()) {
        for (String j : map.keySet()) {
          if (hasShortestPath(map, i, k) && hasShortestPath(map, k, j)) {
            addEdge(map, i, j, map.get(i).get(k) * map.get(k).get(j));
          }
        }
      }
    }

    double[] answers = new double[queries.length];
    for(int i = 0; i < queries.length; i++) {
      String a = queries[i][0];
      String b = queries[i][1];
      answers[i] = getAnswer(map, zero, a, b);
    }
    return answers;
  }

  private boolean hasShortestPath(HashMap<String, HashMap<String, Double>> map, String a, String b) {
    return map.containsKey(a) && map.get(a).containsKey(b);
  }

  private double getAnswer(HashMap<String, HashMap<String, Double>> map, HashSet<String> zero, String a, String b) {
    if (zero.contains(b)) {
      return NO_ANSWER;
    }
    if (zero.contains(a)) {
      return 0.0D;
    }
    if (!map.containsKey(a)) {
      return NO_ANSWER;
    }
    if (!map.get(a).containsKey(b)) {
      return NO_ANSWER;
    }
    return map.get(a).get(b);
  }

  private void addEdge(HashMap<String, HashMap<String, Double>> map, String a, String b, double v) {
    if (!map.containsKey(a)) {
      map.put(a, new HashMap<>());
    }
    map.get(a).put(b, v);
  }
}


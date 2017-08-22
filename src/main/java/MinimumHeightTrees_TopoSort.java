
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * https://leetcode.com/problems/minimum-height-trees/
 */
public class MinimumHeightTrees_TopoSort {

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) {
      return Collections.singletonList(0);
    }

    List<Set<Integer>> adj = new ArrayList<>(n);
    for(int i = 0; i < n; i++) {
      adj.add(new HashSet<>());
    }
    for(int[] edge : edges) {
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }

    Set<Integer> leaves = new HashSet<>();
    for(int i = 0; i < adj.size(); i++) {
      if (adj.get(i).size() == 1) {
        leaves.add(i);
      }
    }

    int remaining = n;
    while(remaining > 2) {
      Set<Integer> newLeaves = new HashSet<>();
      for (int leaf : leaves) {
        for(int leafAdj : adj.get(leaf)) {
          adj.get(leafAdj).remove(leaf);
          if (adj.get(leafAdj).size() == 1) {
            newLeaves.add(leafAdj);
          }
        }
      }
      remaining -= leaves.size();
      leaves = newLeaves;
    }

    List<Integer> answer = new ArrayList<>();
    answer.addAll(leaves);
    return answer;
  }
}

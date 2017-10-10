import java.util.HashMap;


/**
 * https://leetcode.com/problems/redundant-connection/
 */
public class RedundantConnection {
  public int[] findRedundantConnection(int[][] edges) {
    JoinSet joinSet = new JoinSet();

    for(int[] edge : edges) {
      if (joinSet.getGroupId(edge[0]) == joinSet.getGroupId(edge[1])) {
        return edge;
      }
      joinSet.join(edge[0], edge[1]);
    }

    return null;
  }

  private class JoinSet {
    HashMap<Integer, Integer> parents = new HashMap<>();

    void join (int a, int b) {
      int parent_a = getGroupId(a);
      int parent_b = getGroupId(b);
      if (parent_a != parent_b) {
        parents.put(Math.max(parent_a, parent_b), Math.min(parent_a, parent_b));
      }
    }

    int getGroupId(int x) {
      if (!parents.containsKey(x)) {
        return x;
      }

      int root = x;
      int ele = x;
      while(parents.containsKey(ele)) {
        root = parents.get(ele);
        ele = root;
      }

      ele = x;
      while(parents.containsKey(ele)) {
        int p = parents.get(ele);
        parents.put(ele, root);
        ele = p;
      }

      return root;
    }
  }
}

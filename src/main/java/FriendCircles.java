/**
 * https://leetcode.com/problems/friend-circles/
 */
public class FriendCircles {
  public int findCircleNum(int[][] M) {

    if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) {
      return 0;
    }

    UnionFinder uf = new UnionFinder(M.length);
    for(int i = 0; i < M.length; i++) {
      for (int j = 0; j < M[0].length; j++) {
        if (M[i][j] == 1) {
          uf.add(i, j);
        }
      }
    }

    return uf.count;
  }

  private class UnionFinder {
    int[] parent;
    int count = 0;

    UnionFinder(int n) {
      this.count = n;
      this.parent = new int[n];
      for(int i = 0; i < n; i++) {
        this.parent[i] = i;
      }
    }

    int find(int x) {
      int root = x;
      while(parent[root] != root) {
        root = parent[root];
      }

      while(parent[x] != x) {
        int next = parent[x];
        parent[x] = root;
        x = next;
      }

      return root;
    }

    void add(int a, int b) {
      int rootA = find(a);
      int rootB = find(b);
      if (rootA == rootB) {
        return;
      }
      parent[Math.max(rootA, rootB)] = Math.min(rootA, rootB);
      count--;
    }
  }
}


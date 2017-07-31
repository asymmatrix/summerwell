import java.util.HashMap;
import java.util.Map;


/**
 * Array has N integers，range[0...N-1]。Set S[k], 0 <= K < N as S[K] = {A[K], A[A[K]], A[A[A[K]]],....},
 * write a function returns the size of the largest set S[K] for this array. return 0 if empty.
 * ex:
 * A = [5, 4, 0, 3, 1, 6, 2]
 * return 4 because S[2] equals {0, 5, 6, 2} 4 elements
 */
public class ArrayLongestCircle {
  public int runWithDisjointSet(int[] input) {
    DisjointSet ds = new DisjointSet();
    for(int i = 0; i < input.length; i++) {
      ds.union(i, input[i]);
    }
    int[] sum = new int[input.length];
    int result = 0;
    for(int i = 0; i < input.length; i++) {
      int p = ds.find(i);
      sum[p]++;
      result = Math.max(result, sum[p]);
    }
    return result;
  }

  public int runWithVisitedFlag(int[] input) {
    int result = 0;
    for(int i = 0; i < input.length; i++) {
      if (isVisited(input, i)) continue;
      int temp = findCircle(input, i);
      result = Math.max(result, temp);
    }
    return result;
  }

  private int findCircle(int[] input, int start) {
    int sum = 0;
    int x = start;
    while(!isVisited(input, x)) {
      int next = input[x];
      markVisited(input, x);
      sum++;
      x = next;
    }
    return sum;
  }

  private void markVisited(int[] input, int x) {
    input[x] = input[x] * (-1) - 1;
  }

  private boolean isVisited(int[] input, int x) {
    return input[x] < 0;
  }
}

class DisjointSet {

  private Map<Integer, Integer> _leaders = new HashMap<>();

  DisjointSet() {
  }

  void union(int a, int b) {
    int leader_a = find(a);
    int leader_b = find(b);
    _leaders.put(Math.max(leader_a, leader_b), Math.min(leader_a, leader_b));
  }

  int find(int element) {
    if (!_leaders.containsKey(element)) {
      _leaders.put(element, element);
      return element;
    }

    int root = findRoot(element);
    collapse(element, root);

    return root;
  }

  private int findRoot(int element) {
    int x = element;
    while(_leaders.get(x) != x) {
      x = _leaders.get(x);
    }
    return x;
  }

  private void collapse(int element, int root) {
    int x = element;
    while(_leaders.get(x) != root) {
      _leaders.put(x, root);
      x = _leaders.get(x);
    }
  }
}

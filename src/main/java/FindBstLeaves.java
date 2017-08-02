import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Given preorder traversal of a BST, find the leaf nodes without building the tree
 */
public class FindBstLeaves {
  public int[] findLeavesRecursively(int[] preorder) {
    if (preorder == null || preorder.length == 0) {
      return new int[0];
    }

    List<Integer> result = new ArrayList<>();
    findLeavesInSubTree(preorder, 0, preorder.length, result);
    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  private void findLeavesInSubTree(int[] preorder, int lo, int hi, List<Integer> result) {
    if (lo >= hi) {
      return;
    }

    if (lo == hi - 1) {
      result.add(preorder[lo]);
      return;
    }

    int rightTree = lo + 1;
    while(rightTree < hi && preorder[rightTree] < preorder[lo]) rightTree++;
    findLeavesInSubTree(preorder, lo + 1, rightTree, result);
    findLeavesInSubTree(preorder, rightTree, hi, result);
  }

  /**
   * Use a stack to simulate the function frames when doing preorder traversal
   */
  public int[] findLeavesWithStack(int[] preorder) {
    if (preorder == null || preorder.length == 0)
      return new int[] {};

    List<Integer> result = new ArrayList<>();

    Stack<Integer> stack = new Stack<>();
    for(int c = 0, n = 1; n < preorder.length; c++, n++) {
      if (preorder[c] > preorder[n]) {
        stack.push(preorder[c]);
      } else {
        boolean found = false;
        while(!stack.isEmpty()) {
          if (preorder[n] > stack.peek()) {
            stack.pop();
            found = true;
          } else
            break;
        }
        if (found)
          result.add(preorder[c]);
      }

    }
    result.add(preorder[preorder.length-1]);
    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}

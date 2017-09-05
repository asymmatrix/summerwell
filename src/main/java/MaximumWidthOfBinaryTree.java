import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;


/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 */
public class MaximumWidthOfBinaryTree {
  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) return 0;

    int answer = 1;
    Queue<QueueNode> queue = new LinkedList<>();
    queue.offer(new QueueNode(root, BigInteger.ZERO));
    queue.offer(new QueueNode());

    QueueNode levelEnd = null;

    while(!queue.isEmpty()) {
      QueueNode node = queue.poll();
      if (node.treeNode == null) {
        if (!queue.isEmpty()) {
          queue.offer(node);
          // calculate width
          QueueNode levelStart = queue.peek();
          answer = Math.max(answer, levelEnd.value.subtract(levelStart.value).add(BigInteger.ONE).intValue());
        }
      } else {
        if (node.treeNode.left != null) {
          QueueNode newNode = new QueueNode(node.treeNode.left, node.value.multiply(new BigInteger("2")));
          queue.offer(newNode);
          levelEnd = newNode;
        }
        if (node.treeNode.right != null) {
          QueueNode newNode = new QueueNode(node.treeNode.right, node.value.multiply(new BigInteger("2")).add(BigInteger.ONE));
          queue.offer(newNode);
          levelEnd = newNode;
        }
      }
    }

    return answer;
  }

  private class QueueNode {
    TreeNode treeNode;
    BigInteger value;
    QueueNode(TreeNode treeNode, BigInteger value) {
      this.treeNode = treeNode;
      this.value = value;
    }
    QueueNode() {
      this.treeNode = null;
      this.value = null;
    }
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}

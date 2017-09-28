/**
 * https://leetcode.com/problems/rotate-list/
 */

public class RotateList {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) return head;

    Object[] size_tail = findSizeAndTail(head);
    int size = (Integer)size_tail[0];
    k %= size;

    ListNode tail = (ListNode)size_tail[1];

    if (k == 0) return head;

    ListNode newHead = head;
    ListNode newTail = null;
    for (int i = 0; i < size - k; i++) {
      newTail = newHead;
      newHead = newHead.next;
    }

    newTail.next = null;
    tail.next = head;

    return newHead;
  }

  private Object[] findSizeAndTail(ListNode head) {
    int cnt = 0;
    ListNode tail = head;
    while(head != null) {
      cnt++;
      tail = head;
      head = head.next;
    }
    return new Object[] {cnt, tail};
  }

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
}

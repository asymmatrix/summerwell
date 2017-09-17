/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null || m <= 0 || m >= n) {
      return head;
    }

    ListNode prev = null;
    for(int i = 1; i < m; i++) {
      if (prev == null) prev = head;
      else prev = prev.next;
    }

    int step = n - m;
    ListNode p = (prev == null ? head : prev.next);
    ListNode q = p.next;
    for(int i = 0; i < step; i++) {
      ListNode temp = q.next;
      q.next = p;
      p = q;
      q = temp;
    }

    if (prev != null) {
      ListNode temp = prev.next;
      prev.next = p;
      temp.next = q;
      return head;
    } else {
      head.next = q;
      return p;
    }
  }

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
}

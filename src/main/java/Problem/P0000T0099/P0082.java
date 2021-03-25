package Problem.P0000T0099;

/**
 * Time  : 2021/3/25 10:12
 * Author: Banehallow
 */
public class P0082 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = new ListNode(0,  head), q = p;
        while (q.next != null) {
            ListNode l = q.next, r = l;
            while (r.next != null && r.next.val == l.val) r = r.next;
            if (l != r) {
                q.next = r.next;
            } else {
                q = q.next;
            }
        }
        return p.next;
    }
}

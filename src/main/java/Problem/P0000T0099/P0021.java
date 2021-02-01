package Problem.P0000T0099;

/**
 * Date  :  2020/12/18
 * Author:  YiPing, Wei
 **/
public class P0021 {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2, h = new ListNode(), t = h;
        while (p != null || q != null) {
            if (p != null && q != null) {
                if (p.val <= q.val) {
                    t.next = p;
                    while (t.next != null && t.next.val <= q.val) t = t.next;
                    p = t.next;
                    t.next = null;
                } else {
                    t.next = q;
                    while (t.next != null && t.next.val <= p.val) t = t.next;
                    q = t.next;
                    t.next = null;
                }
            } else if (p != null) {
                t.next = p;
                p = null;
            } else {
                t.next = q;
                q = null;
            }
        }
        return h.next;
    }
}

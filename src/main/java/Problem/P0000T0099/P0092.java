package Problem.P0000T0099;

/**
 * Time  : 2021/3/18 10:14
 * Author: Banehallow
 */
public class P0092 {
    static class ListNode {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode p, q, l, r, tmp, vh = new ListNode(-1, head);
        if (right == left) return head;
        p = vh;
        for (int i = 1; i < left; i++) p = p.next;
        l = p.next;
        q = l;
        r = l.next;
        for (int i = left; i < right; i++) {
            if (r == null) break; // 队尾边界
            tmp = r.next;
            r.next = l;
            l = r;
            r = tmp;
        }
        p.next = l;
        q.next = r;
        return vh.next;
    }
}

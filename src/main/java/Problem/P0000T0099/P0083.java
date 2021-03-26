package Problem.P0000T0099;

/**
 * Time  : 2021/3/26 10:15
 * Author: Banehallow
 */
public class P0083 {
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
        ListNode p = head;
        while (p != null) {
            while (p.next != null && p.next.val == p.val)
                p.next = p.next.next;
            p = p.next;
        }
        return head;
    }
}

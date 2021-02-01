package Problem.P0000T0099;

public class P0019 {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 首先计算链表长度
        int len = 0;
        ListNode p = head;
        while (p!=null) {
            p = p.next;
            len++;
        }
        // 倒数n换成正数m
        int m = len - n;
        p = head;
        if (m == 0) {
            // 处理删除头结点情况
            head = head.next;
            p.next = null;
        } else {
            // 对于中间结点，取巧为删除该节点的上一个节点或者用下一个节点覆盖
            m--;
            while (m > 0) {
                p = p.next;
                m--;
            }
            ListNode q = p.next;
            p.next = q.next;
            q.next = null;
        }
        return head;
    }
}

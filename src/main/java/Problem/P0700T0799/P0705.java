package Problem.P0700T0799;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-03-13
 *******************************************
 **/
public class P0705 {
    static class MyHashSet {
        static class Node {
            int key;
            Node next;

            Node(int k) {
                key = k;
                next = null;
            }
        }

        private Node[] nodes;
        private int size;
        private static final int capacity = 1000;

        public MyHashSet() {
            nodes = new Node[capacity];
            size = 0;
        }

        private int hash(int key) {
            // key最大为10^6,我们用前三位和后三位做与运算保证哈希值分布均匀
            return key % capacity & key / capacity;
        }

        public void add(int key) {
            if (!contains(key)) {
                int i = hash(key);
                if (nodes[i] == null) {
                    // 链空则生成链头
                    nodes[i] = new Node(key);
                } else {
                    // 链非空用头插
                    Node p = new Node(key);
                    p.next = nodes[i];
                    nodes[i] = p;
                }
            }
        }

        public void remove(int key) {
            int i = hash(key);
            if (nodes[i] == null) return;
            Node p = nodes[i], q = p.next;
            if (p.key == key) {
                // 删除队头逻辑
                nodes[i] = q;
                // help GC
                p.next = null;
                p = null;
            } else {
                // 进行链搜索,p引用删除k的前一个节点,q引用k节点
                while (q != null && q.key != key) {
                    p = p.next;
                    q = q.next;
                }
                // q插找到了k
                if (q != null) {
                    p.next = q.next;
                    // help GC
                    q.next = null;
                    q = null;
                }
            }
        }

        public boolean contains(int key) {
            int i = hash(key);
            if (nodes[i] == null) return false;
            Node p = nodes[i];
            while (p.key != key && p.next != null) p = p.next;
            return p.key == key;
        }
    }
}

package Problem.P0700T0799;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-03-14
 *******************************************
 **/
public class P0706 {
    static class MyHashMap {
        static class Node {
            int key;
            int value;
            Node next;

            Node(int k, int v) {
                key = k;
                value = v;
                next = null;
            }
        }

        private Node[] nodes;
        private int size;
        private static final int capacity = 1000;

        public MyHashMap() {
            nodes = new Node[capacity];
            size = 0;
        }

        private int hash(int key) {
            // key最大为10^6,我们用前三位和后三位做与运算保证哈希值分布均匀
            return key % capacity & key / capacity;
        }

        public void put(int key, int value) {
            Node q = find(key);
            if (q != null) {
                // 找到了覆盖值
                q.value = value;
            } else {
                int i = hash(key);
                if (nodes[i] == null) {
                    // 链空则生成链头
                    nodes[i] = new Node(key, value);
                } else {
                    // 链非空用头插
                    Node p = new Node(key, value);
                    p.next = nodes[i];
                    nodes[i] = p;
                }
            }
        }

        public int get(int key) {
            Node p = find(key);
            if (p != null) return p.value;
            return -1;
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

        private Node find(int key) {
            int i = hash(key);
            if (nodes[i] == null) return null;
            Node p = nodes[i];
            while (p != null && p.key != key) p = p.next;
            return p;
        }
    }
}

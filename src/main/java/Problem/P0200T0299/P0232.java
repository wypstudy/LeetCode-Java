package Problem.P0200T0299;

import java.util.LinkedList;

/**
 * Time  : 2021/3/5 09:46
 * Author: Banehallow
 * =========================
 * 使用lazy模式
 * 即a栈负责入,b栈负责出
 * 当碰到入的时候把b的内容都装入a,然后只操作a
 * 当碰到出的时候把a的内容都装入b,然后只操作b
 * 对于先入队n个数再出队n个数有时间复杂度 O(1)*n 入队 + O(n) 切换栈 + O(1)*n 出队
 * 均摊时间复杂度为 O(3n/2n) = O(3/2) 为常数阶所以是 O(1)
 * 当然在经常切换入队和出队操作的情况下性能略差
 */
public class P0232 {
    static class MyQueue {
        int size;
        boolean push;
        LinkedList<Integer> a, b; // a负责入队 b负责出队 这里我们假定使用的是栈,只能用last相关操作

        /** Initialize your data structure here. */
        public MyQueue() {
            size = 0;
            a = new LinkedList<Integer>();
            b = new LinkedList<Integer>();
            push = true; // 默认处于入队状态
        }

        private void reverse() {
            if (push) {
                // 入队状态切换到出队状态
                push = false;
                while (a.size() > 0) {
                    b.addLast(a.getLast());
                    a.removeLast();
                }
            } else {
                // 出队状态切换到入队状态
                push = true;
                while (b.size() > 0) {
                    a.addLast(b.getLast());
                    b.removeLast();
                }
            }
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            size++;
            if (!push) reverse(); // 如果不处在入队状态则反向
            a.addLast(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            size--;
            if (push) reverse(); // 如果不处在出队状态则反向
            int re = b.getLast();
            b.removeLast();
            return re;
        }

        /** Get the front element. */
        public int peek() {
            if (push) reverse(); // 如果不处在出队状态则反向
            return b.getLast();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return size == 0;
        }
    }
}

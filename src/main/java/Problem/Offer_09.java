package Problem;

import java.util.Stack;

/**
 * Date  :  2020/6/30
 * Author:  YiPing, Wei
 **/
public class Offer_09 {
    public static class CQueue {
        Stack<Integer> a;
        Stack<Integer> b;
        public CQueue() {
            a = new Stack<>();
            b = new Stack<>();
        }

        public void appendTail(int value) {
            while (!a.empty()) {
                b.push(a.pop());
            }
            a.push(value);
            while (!b.empty()) {
                a.push(b.pop());
            }
        }

        public int deleteHead() {
            if (!a.empty())
                return a.pop();
            else
                return -1;
        }
    }
}

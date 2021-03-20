package Problem.P0100T0199;

import java.util.Stack;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-03-20
 *******************************************
 **/
public class P0150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            int x;
            switch (token) {
                case "+":
                    x = stack.pop() + stack.pop();
                    stack.push(x);
                    break;
                case "-":
                    x = -stack.pop() + stack.pop();
                    stack.push(x);
                    break;
                case "*":
                    x = stack.pop() * stack.pop();
                    stack.push(x);
                    break;
                case "/":
                    x = stack.pop();
                    x = stack.pop() / x;
                    stack.push(x);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}

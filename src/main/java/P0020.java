import java.util.LinkedList;

/**
 * 栈实现左右括号对齐,注意边界情况:
 *   空输入
 *   只有左括号
 *   只有右括号
 */
public class P0020 {
    public boolean isValid(String s) {
        String left = "{[(",right="}])";
        LinkedList<Character> l = new LinkedList<>();
        for (Character c:s.toCharArray()) {
            int leftIndex = left.indexOf(c);
            int rightIndex = right.indexOf(c);
            if (leftIndex > -1) {
                l.push(c);
            } else if (l.size()==0||left.indexOf(l.pop())!=rightIndex) {
                // 处理只有右括号,或者左右括号不对称情况
                return false;
            }
        }
        // 处理只有左括号情况
        return l.size() <= 0;
    }
}

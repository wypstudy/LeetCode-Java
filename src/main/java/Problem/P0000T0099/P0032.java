package Problem.P0000T0099;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-05
 *******************************************
 **/
public class P0032 {
    public int longestValidParentheses(String s) {
        int ans = 0, left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            if (left == right)
                ans = Math.max(ans, 2 * right);
            else if (right > left)
                left = right = 0;
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            if (left == right)
                ans = Math.max(ans, 2 * right);
            else if (left > right)
                left = right = 0;
        }
        return ans;
    }
}

package Problem.P1000T1099;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-23
 *******************************************
 * 滑动窗口
 **/
public class P1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length, sure = 0, other = 0, maxOther = 0;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) sure += customers[i];
        }
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) other += customers[i];
        }
        maxOther = other;
        for (int i = X; i < len; i++) {
            if (grumpy[i - X] == 1) other -= customers[i-X];
            if (grumpy[i] == 1) other += customers[i];
            maxOther = Math.max(maxOther, other);
        }
        return sure + maxOther;
    }
}

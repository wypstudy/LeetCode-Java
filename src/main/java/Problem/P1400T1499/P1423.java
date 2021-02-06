package Problem.P1400T1499;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-06
 *******************************************
 * 滑动窗口
 * 我们知道最后剩下的肯定是长度为 n - k 的一个子串
 * 那么就求这个子串和最小
 * 拿总和减去子串和就是最大数
 **/
public class P1423 {
    public int maxScore(int[] cardPoints, int k) {
        int x = cardPoints.length - k, sum = 0, window = 0, minWindow;
        for (int i = 0; i < cardPoints.length; i++) {
            sum += cardPoints[i];
            if (i == x - 1) {
                window = sum;
            }
        }
        minWindow = window;
        for (int i = x; i < cardPoints.length; i++) {
            window = window + cardPoints[i] - cardPoints[i - x];
            minWindow = Math.min(minWindow, window);
        }
        return sum - minWindow;
    }
}

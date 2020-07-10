/**
 * Date  :  2020/7/10
 * Author:  YiPing, Wei
 **/
public class P0309 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 0)
            return 0;
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        int last = prices.length - 1;
        return Math.max(Math.max(dp[last][0], dp[last][1]), dp[last][2]);
    }
}

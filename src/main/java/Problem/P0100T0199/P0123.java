package Problem.P0100T0199;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-01-09
 *******************************************
 * price[i] 中 i 表示天数 值是当天股票价格
 * dp[i][j] 中 i 表示天数 j 表示状态
 *     j = 0 时表示第 i 买入第一次股票的最高价值
 *     j = 1 时表示第 i 卖出第一次股票的最高价值
 *     j = 2 时表示第 i 买入第二次股票的最高价值
 *     j = 3 时表示第 i 卖出第二次股票的最高价值
 * 有转移方程
 * dp[i][0] = max(-prices[i], dp[i-1][0])
 * dp[i][1] = max(dp[i-1][0] + prices[i], dp[i-1][1])
 * dp[i][2] = max(dp[i-1][1] - prices[i], dp[i-1][2])
 * dp[i][3] = max(dp[i-1][2] + prices[i], dp[i-1][3])
 **/
public class P0123 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][1] = -9999999;
        dp[0][2] = -9999999;
        dp[0][3] = -9999999;
        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = -prices[i];
            if (i > 0) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i][0]);
                dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
                dp[i][2] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][2]);
                dp[i][3] = Math.max(dp[i - 1][2] + prices[i], dp[i - 1][3]);
            }
        }
        int ans = 0;
        ans = Math.max(ans, dp[prices.length - 1][1]);
        ans = Math.max(ans, dp[prices.length - 1][3]);
        return ans;
    }

    public static void main(String[] args) {
        P0123 solution = new P0123();
        int[] prices1 = {3,3,5,0,0,3,1,4};
        System.out.println(solution.maxProfit(prices1));
        int[] prices2 = {1,2,3,4,5};
        System.out.println(solution.maxProfit(prices2));
    }
}

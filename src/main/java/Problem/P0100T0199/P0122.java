package Problem.P0100T0199;

/**
 * 动态规划
 * dp[i][0] 表示第i天不买股票最大利润
 * dp[i][1] 表示第i天买股票最大利润
 * 则状态转移方程如下
 * dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i])
 * dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i])
 */
public class P0122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }
        return  Math.max(dp[len-1][0],dp[len-1][1]);
    }
}

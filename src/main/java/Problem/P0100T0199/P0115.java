package Problem.P0100T0199;

/**
 * Time  : 2021/3/17 10:30
 * Author: Banehallow
 * 动态规划
 * 设 dp[i][j]表示s到第i个字符为止,t到第j个字符为止的匹配数
 * 有状态转移方程
 * 当 s[i] = t[j], dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
 * 当 s[i] != t[j], dp[i][j] = dp[i-1][j]
 * 边界条件为j=0的时候t为空串,i的所有值都含有该字串即 dp[i][0]=1
 */
public class P0115 {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1; // 边界
        for (int i = 1; i <= n; i++) {
            char sc = s.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char tc = t.charAt(j - 1);
                if (sc == tc) { // 字符匹配情况
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else { // 字符未匹配情况
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}

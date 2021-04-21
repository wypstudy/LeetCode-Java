package Problem.P0000T0099;

/**
 * Time  : 2021/4/21 18:48
 * Author: Banehallow
 * dp[i] 表示第i位的方法数
 *  边界 dp[0]=1
 *  dp[i] = 0
 *  如果s[i-1]不为'0',表示当前字符可以编码,dp[i] += dp[i-1]
 *  如果s[i-2]不为'0',且s.sub(i-2,i-1)组成的字符串小于"27", dp[i] += dp[i-2]
 */
public class P0091 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = 0;
            if (s.charAt(i - 1) != '0') dp[i] += dp[i - 1];
            if (i > 1 && s.charAt(i - 2) != '0'
                    && (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}

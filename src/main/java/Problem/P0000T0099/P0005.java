package Problem.P0000T0099;

public class P0005 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0)
            return "";
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                dp[i][j] = i == j;
        int maxLeft = 0, maxRight = 0, maxLen = 1;
        for (int l = 1; l < len; l++)
            for (int i = 0; i < len - l; i++) {
                dp[i][i + l] = (dp[i + 1][i + l - 1] || l == 1) && s.charAt(i) == s.charAt(i + l);
                if (dp[i][i+l] && l + 1 > maxLen) {
                    maxLeft = i;
                    maxRight = i + l;
                    maxLen = l + 1;
                }
            }
        return s.substring(maxLeft, maxRight+1);
    }

    public static void main(String[] args) {
        P0005 solution = new P0005();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}

package Problem.P0000T0099;

/**
 * Date  :  2020/6/9
 * Author:  YiPing, Wei
 **/
public class P0046 {
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int size = numStr.length();
        int[] dp = new int[size];
        dp[0] = 1;
        if (size > 1) {
            if (Integer.parseInt(numStr.substring(0, 2)) < 26)
                dp[1] = 2;
            else
                dp[1] = 1;
        }

        for (int i = 2; i < size; i++) {
            if (numStr.charAt(i-1) > '0' && Integer.parseInt(numStr.substring(i - 1, i + 1)) < 26)
                dp[i] = dp[i - 2] + dp[i - 1];
            else
                dp[i] = dp[i - 1];
        }
        return dp[size - 1];
    }

    public static void main(String[] args) {
        P0046 solution = new P0046();
        System.out.println(solution.translateNum(12258));
        System.out.println(solution.translateNum(506));
    }
}

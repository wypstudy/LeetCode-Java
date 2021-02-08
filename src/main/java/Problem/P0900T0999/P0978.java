package Problem.P0900T0999;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-08
 *******************************************
 **/
public class P0978 {
    public int maxTurbulenceSize(int[] arr) {
        int[][] dp = new int[arr.length][2];
        int ans = 1 ;
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = 1;
            } else if (arr[i] > arr[i - 1]) {
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = 1;
            } else {
                dp[i][0] = 1;
                dp[i][1] = 1;
            }
            ans = Math.max(dp[i][0], ans);
            ans = Math.max(dp[i][1], ans);
        }
        return ans;
    }
}

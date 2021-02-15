package Problem.P0400T0499;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-15
 *******************************************
 **/
public class P0485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 0;
        if (nums[0] == 1)
            dp[0] = 1;
        else
            dp[0] = 0;
        for (int i = 1; i < nums.length;i++) {
            if (nums[i] == 1) {
                dp[i] = dp[i-1] + 1;
            } else {
                ans = Math.max(dp[i-1], ans);
            }
        }
        return Math.max(ans, dp[nums.length - 1]);
    }
}

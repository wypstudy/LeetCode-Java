package Problem.P0700T0799;

import java.util.Arrays;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-05-05
 *******************************************
 **/
public class P0740 {
    public int deleteAndEarn(int[] nums) {
        int[] bucket = new int[10001], dp = new int[10001];
        Arrays.fill(bucket, 0);
        Arrays.fill(dp, 0);
        for (int i : nums) {
            bucket[i] += i;
        }
        dp[0] = bucket[0];
        dp[1] = bucket[1];
        for (int i = 2; i <= 10000; i++)
            dp[i] = Math.max(dp[i - 2] + bucket[i], dp[i - 1]);
        return dp[10000];
    }
}

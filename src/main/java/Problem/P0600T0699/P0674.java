package Problem.P0600T0699;

import java.util.Arrays;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-01-24
 *******************************************
 * dp[i] 默认全部为 1
 * 当前数比上一个数大则有 dp[i] = dp[i - 1] + 1
 **/
public class P0674 {
    public int findLengthOfLCIS(int[] nums) {
        // 空数组则返回 0
        if (nums.length == 0) return 0;
        // 非空则至少返回 1
        int ans = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                if (dp[i] > ans) ans = dp[i];
            }
        }
        return ans;
    }
}

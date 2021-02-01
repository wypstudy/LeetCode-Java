package Problem.P0300T0399;

/**
 * Date  :  2020/11/7
 * Author:  YiPing, Wei
 * 327-区间和的个数
 * DP+状态压缩
 * dp[l][r]表示l到r的区间和有方程 dp[l][r]=dp[l][r-1]+nums[r]
 * 压缩到1维不存状态有 dp[l] = dp[l] + nums[r]
 **/
public class P0327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length, count = 0;
        long[] now = new long[len];
        for (int dis = 0; dis < len; dis++) {
            int maxLeft = len - dis;
            for (int left = 0; left < maxLeft; left++) {
                int right = left + dis;
                now[left] = now[left] + nums[right];
                if (now[left] >= lower && now[left] <= upper)
                    count++;
            }
        }
        return count;
    }
}

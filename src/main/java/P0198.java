/**
 * Date  :  2020/5/29
 * Author:  YiPing, Wei
 **/
public class P0198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        int[][] dp = new int[len][2];
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    public static void main(String[] args) {
        P0198 solution = new P0198();
        int[] rob1 = {2, 1, 1, 2};
        int[] rob2 = {2, 7, 9, 3, 1};
        System.out.println(solution.rob(rob1));
        System.out.println(solution.rob(rob2));
    }
}

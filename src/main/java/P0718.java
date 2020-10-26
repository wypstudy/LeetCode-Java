/**
 * Date  :  2020/7/1
 * Author:  YiPing, Wei
 * 动态规划
 * 设 dp[i][j] 为 A 的 第i位置和 B的 第 j 位置的最长连续公共子串
 * 状态转移方程 dp[i][j] = dp[i-1][j-1]+1
 **/
public class P0718 {
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length, ans = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (A[i] == B[j]) {
                    if (i > 0 && j > 0)
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = 1;
                    if (dp[i][j] > ans)
                        ans = dp[i][j];
                }
        return ans;
    }

    public static void main(String[] args) {
        P0718 solution = new P0718();
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        System.out.println(solution.findLength(A, B));
    }
}

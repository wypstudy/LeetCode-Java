package Problem;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-07-01
 *******************************************
 **/
public class LCP_07 {
    public int numWays(int n, int[][] relation, int k) {
        boolean[][] map = new boolean[n][n];
        for (int[] ints : relation) {
            map[ints[0]][ints[1]] = true;
        }
        int[][] dp = new int[n][k + 1];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[j][i] > 0) {
                    for (int x = 0; x < n; x++) {
                        if (map[j][x]) {
                            dp[x][i+1] += dp[j][i];
                        }
                    }
                }
            }
        }
        return dp[n-1][k];
    }
}

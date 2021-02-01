package Problem.P0900T0999;

/**
 * Date  :  2020/11/9
 * Author:  YiPing, Wei
 **/
public class P0973 {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            ans[i][0] = 10000;
            ans[i][1] = 10000;
        }
        for (int i = 0; i < points.length; i++) {
            int j = K;
            double pointDistance = Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2);
            while (j > 0 && Math.pow(ans[j - 1][0], 2) + Math.pow(ans[j - 1][1], 2) > pointDistance)
                j--;
            if (j == K)
                continue;
            for (int k = K - 1; k > j; k--) {
                ans[k][0] = ans[k - 1][0];
                ans[k][1] = ans[k - 1][1];
            }
            ans[j][0] = points[i][0];
            ans[j][1] = points[i][1];
        }
        return ans;
    }
}

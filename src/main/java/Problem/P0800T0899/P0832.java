package Problem.P0800T0899;

import java.util.Arrays;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-24
 *******************************************
 **/
public class P0832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] ans = new int[A.length][];
        for (int i = 0; i < A.length; i++) {
            ans[i] = new int[A[i].length];
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    ans[i][A[i].length - j - 1] = 0;
                } else {
                    ans[i][A[i].length - j - 1] = 1;
                }
            }
        }
        return ans;
    }
}

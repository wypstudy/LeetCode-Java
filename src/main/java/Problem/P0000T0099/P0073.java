package Problem.P0000T0099;

import java.util.Arrays;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-03-21
 *******************************************
 **/
public class P0073 {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[] col = new boolean[n], row = new boolean[m];
        Arrays.fill(col, false);
        Arrays.fill(row, false);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    col[i] = true;
                    row[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (col[i] || row[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

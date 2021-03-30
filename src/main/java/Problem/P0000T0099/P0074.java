package Problem.P0000T0099;

import java.util.Arrays;

/**
 * Time  : 2021/3/30 10:35
 * Author: Banehallow
 */
public class P0074 {

    static public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        if (target < matrix[0][0]|| target > matrix[n - 1][m - 1]) return false;
        int[] rows = new int[n];
        for (int i = 0; i < n; i++) rows[i] = matrix[i][0];
        int x = Arrays.binarySearch(rows, target);
        if (x >= 0)
            return true;
        else {
            x = -x - 2;
            int[] cols = matrix[x];
            int y = Arrays.binarySearch(cols, target);
            return y > 0;
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        searchMatrix(m, 3);
    }
}

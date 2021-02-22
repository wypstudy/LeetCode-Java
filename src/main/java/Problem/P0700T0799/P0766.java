package Problem.P0700T0799;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-22
 *******************************************
 **/
public class P0766 {
    int[][] globalMatrix;
    int row, col;
    private boolean check(int x, int y) {
        while (x < row && y < col) {
            if (x > 0 && y > 0 && globalMatrix[x][y] != globalMatrix[x-1][y-1]) return false;
            x++;
            y++;
        }
        return true;
    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        globalMatrix = matrix;
        row = matrix.length;
        col = matrix[0].length;
        for (int y = 0; y < col; y++) {
            if (!check(0, y)) return false;
        }
        for (int x = 1; x < row; x++) {
            if (!check(x, 0)) return false;
        }
        return true;
    }
}

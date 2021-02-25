package Problem.P0800T0899;

public class P0867 {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] ans = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}

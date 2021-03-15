package Problem.P0000T0099;

import java.util.ArrayList;
import java.util.List;

/**
 * Time  : 2021/3/15 10:43
 * Author: Banehallow
 */
public class P0054 {
    int n,m;
    boolean[][] visit;
    static final int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
    int moveIndex;
    private boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m && !visit[x][y];
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        visit = new boolean[n][m];
        moveIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = false;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        int i = 0, j = 0, maxSteps = n * m, step = 0;
        while (step < maxSteps) {
            ans.add(matrix[i][j]);
            visit[i][j] = true;
            int nextI = i + move[moveIndex][0];
            int nextJ = j + move[moveIndex][1];
            if (!check(nextI, nextJ)) {
                moveIndex = (moveIndex + 1) % 4;
                nextI = i + move[moveIndex][0];
                nextJ = j + move[moveIndex][1];
            }
            i = nextI;
            j = nextJ;
            step++;
        }
        return ans;
    }
}

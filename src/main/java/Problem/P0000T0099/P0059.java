package Problem.P0000T0099;

import java.util.ArrayList;
import java.util.List;

/**
 * Time  : 2021/3/16 10:12
 * Author: Banehallow
 */
public class P0059 {
    int n;
    boolean[][] visit;
    static final int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
    int moveIndex;
    private boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n && !visit[x][y];
    }
    public int[][] generateMatrix(int n) {
        this.n = n;
        visit = new boolean[n][n];
        moveIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visit[i][j] = false;
            }
        }
        int[][] ans = new int[n][n];
        int i = 0, j = 0, maxSteps = n * n + 1, step = 1;
        while (step < maxSteps) {
            ans[i][j] = step ;
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

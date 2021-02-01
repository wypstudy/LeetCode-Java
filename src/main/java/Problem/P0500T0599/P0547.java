package Problem.P0500T0599;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-01-07
 *******************************************
 * 简单并查集
 **/
public class P0547 {
    private int father(int[] f, int x) {
        if (f[x] == x)
            return x;
        return f[x] = father(f, f[x]);
    }

    public int findCircleNum(int[][] isConnected) {
        int[] f = new int[isConnected.length];
        for (int i = 0; i < f.length; i++)
            f[i] = i;
        for (int i = 0; i < f.length - 1; i++) {
            for (int j = i + 1; j < f.length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    int iFather = father(f, i), jFather = father(f, j);
                    if (iFather != jFather) {
                        if (iFather < jFather) {
                            f[jFather] = iFather;
                        } else {
                            f[iFather] = jFather;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < f.length; i++) {
            if (father(f, i) == i) ans++;
        }
        return ans;
    }
}

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-01-13
 *******************************************
 * 并查集表示两个点是否连通
 * 连通1次为树边不用管
 * 连通2次为附加边,返回
 **/
public class P0684 {
    private int father(int[] f, int x) {
        if (f[x] == x)
            return x;
        return f[x] = father(f, f[x]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] f = new int[1001];
        for (int i = 0;i < 1001;i++) f[i] = i;
        for (int[] edge : edges) {
            int af = father(f, edge[0]);
            int bf = father(f, edge[1]);
            if (af < bf) {
                f[bf] = af;
            } else if (af > bf) {
                f[af] = bf;
            } else {
                return edge;
            }
        }
        return new int[0];
    }

}

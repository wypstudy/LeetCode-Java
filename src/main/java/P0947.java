/**
 * Date  :  2021/1/15
 * Author:  YiPing, Wei
 **/
public class P0947 {
    private int findFather(int[] f, int x) {
        if (f[x] == x)
            return x;
        // 路径压缩
        f[x] = findFather(f, f[x]);
        return f[x];
    }

    public int removeStones(int[][] stones) {
        int[] f = new int[1000];
        int[] xF = new int[10001];
        int[] yF = new int[10001];
        for (int i = 0; i < 1000; i++) {
            f[i] = i;
        }
        for (int i = 0; i < 10001;i++) {
            xF[i] = -1;
            yF[i] = -1;
        }
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            int[] stone = stones[i];
            count++;
            int xFirst = xF[stone[0]];
            int yFirst = yF[stone[1]];
            if (xFirst == -1 && yFirst == -1) {
                // x 和 y 轴都没有连通分量,只需记录当前连通分量到 x 和 y 轴
                xF[stone[0]] = i;
                yF[stone[1]] = i;
            } else if (xFirst != -1 && yFirst != -1) {
                // x 和 y 轴都有连通分量,需要合并两个连通分量
                int xRoot = findFather(f, xFirst);
                int yRoot = findFather(f, yFirst);
                if (xRoot != yRoot) {
                    count--;
                    if (xRoot > yRoot)
                        f[xRoot] = yRoot;
                    else
                        f[yRoot] = xRoot;
                }
                // 把当前连通分量合入
                count--;
                f[i] = Math.min(xRoot, yRoot);
            } else {
                // y 轴有连通分量
                if (xFirst == -1) {
                    xF[stone[0]] = i;
                    int yRoot = findFather(f, yFirst);
                    count--;
                    f[i] = yRoot;
                }
                // x 轴有连通分量
                if (yFirst == -1) {
                    yF[stone[1]] = i;
                    int xRoot = findFather(f, xFirst);
                    count--;
                    f[i] = xRoot;
                }
            }
        }
        return stones.length - count;
    }
}

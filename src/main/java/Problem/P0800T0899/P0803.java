package Problem.P0800T0899;

import java.util.Arrays;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-01-16
 *******************************************
 * 思路
 * 逆序思维+并查集
 * 数组 f[x*n+y] 表示 第 x 行 第 y 列的砖块属于哪个连通分量
 **/
public class P0803 {
    private static class UnionFind {
        /**
         * parent[i]表示第i个节点的父节点
         */
        private int[] parent;
        /**
         * size[i]表示第i个节点为根节点时的子节点数
         */
        private int[] size;

        /**
         * 初始化size为n的并查集
         *
         * @param n 并查集大小
         */
        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        /**
         * 查找索引为 x 的节点的根节点
         *
         * @param x 要查找的节点索引
         * @return 根节点索引
         */
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        /**
         * 合并索引 x 和 y 的两个节点的根节点
         *
         * @param x 一个节点的索引
         * @param y 另一个节点的索引
         */
        public void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) return;
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }

        /**
         * 返回根节点为 x 时候的节点数
         *
         * @param x 根节点索引
         * @return 节点数
         */
        public int getSize(int x) {
            return size[find(x)];
        }
    }

    final private static int[] XM = {1, -1, 0, 0};
    final private static int[] YM = {0, 0, 1, -1};
    private int rows;
    private int cols;


    private boolean checkXY(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] == 1;
    }

    private int toIndex(int x, int y) {
        return x * cols + y;
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        int size = cols * rows;
        int[][] copy = new int[rows][cols];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                copy[x][y] = grid[x][y];
            }
        }
        int[] ans = new int[hits.length];
        UnionFind uf = new UnionFind(size + 1);

        // 先把砖块打掉
        for (int[] hit : hits) {
            copy[hit[0]][hit[1]] = 0;
        }

        // 顶部砖块连通
        for (int y = 0; y < cols; y++) {
            if (copy[0][y] == 1) {
                uf.union(y, size);
            }
        }

        // 其余砖块连通
        for (int x = 1; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                // 有砖块就和左边或上边的方块链接
                if (copy[x][y] == 1) {
                    // 上边连接
                    if (checkXY(copy, x - 1, y)) uf.union(toIndex(x, y), toIndex(x - 1, y));
                    // 左边连接
                    if (checkXY(copy, x, y - 1)) uf.union(toIndex(x, y), toIndex(x, y - 1));
                }
            }
        }

        // 倒序安装回砖块
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];

            // 原来没有砖块,安不安没影响
            if (grid[x][y] == 0) continue;

            int before = uf.getSize(size);

            // 如果在顶部 x == 0,则与屋顶链接
            if (x == 0) {
                uf.union(y, size);
            }

            // 安装砖块
            for (int j = 0; j < 4; j++) {
                int xm = x + XM[j], ym = y + YM[j];
                // 四个方向都合并
                if (checkXY(copy, xm, ym)) {
                    uf.union(toIndex(x, y), toIndex(xm, ym));
                }
            }

            int after = uf.getSize(size);

            ans[i] = Math.max(after - before - 1, 0);

            copy[x][y] = 1;
        }
        return ans;
    }
}

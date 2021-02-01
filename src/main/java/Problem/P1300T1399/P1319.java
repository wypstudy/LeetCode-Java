package Problem.P1300T1399;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-01-23
 *******************************************
 * 连通分量定义 + 并查集
 **/
public class P1319 {
    public int makeConnected(int n, int[][] connections) {
        // 网线不够
        if (n > connections.length + 1) return -1;

        UnionFind uf = new UnionFind(n);
        for (int[] connection:connections) {
            uf.union(connection[0], connection[1]);
        }
        return uf.getSize()-1;
    }

    private class UnionFind {

        /**
         * 当前结点的父亲结点
         */
        private int[] parent;
        /**
         * 当前连通分量数
         */
        private int size;

        public UnionFind(int n) {
            parent = new int[n];
            size = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /**
         * 路径压缩
         *
         * @param x
         * @return
         */
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            // 在合并的时候减少连通分量数
            size--;
        }

        /**
         * @return 并查集的连通分量数
         */
        public int getSize() {
            return size;
        }
    }
}

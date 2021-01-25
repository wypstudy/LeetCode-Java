/**
 * Date  :  2021/1/25
 * Author:  YiPing, Wei
 * ############################
 * 抽象成如图   \0 /
 *           3 \/ 1
 *             /\
 *            /2 \
 * 有格子内部
 * a. 左斜杠 0+3 1+2
 * b. 右斜杠 0+1 2+3
 * 格子之间
 * a. 左格子和右格子 1+3
 * b. 上格子和下格子 2+0
 **/
public class P0959 {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length, size = n * n * 4;
        UnionFind uf = new UnionFind(size);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int gridIndex = (i * n + j) * 4;
                // 格子内部合并
                if (grid[i].charAt(j) == '/') {
                    // 左斜杠处理
                    uf.union(gridIndex, gridIndex + 3);
                    uf.union(gridIndex + 1, gridIndex + 2);
                } else if (grid[i].charAt(j) == '\\') {
                    // 右斜杠处理
                    uf.union(gridIndex, gridIndex + 1);
                    uf.union(gridIndex + 2, gridIndex + 3);
                } else {
                    // 无斜杠全合并
                    uf.union(gridIndex, gridIndex + 1);
                    uf.union(gridIndex, gridIndex + 2);
                    uf.union(gridIndex, gridIndex + 3);
                }
                // 格子间合并,保证只往右和往下合并
                if (j < n - 1) {
                    // 右合并
                    uf.union(gridIndex + 1, gridIndex + 7);
                }
                if (i < n - 1) {
                    // 下合并
                    uf.union(gridIndex + 2, gridIndex + n * 4);
                }
            }
        }
        return uf.getSize();
    }

    static class UnionFind {
        private int[] parent;
        private int size;

        public UnionFind(int n) {
            size = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x)
                return x;
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int xParent = find(x), yParent = find(y);
            if (xParent == yParent) {
                return false;
            }
            parent[yParent] = xParent;
            size--;
            return true;
        }

        public int getSize() {
            return size;
        }
    }
}

import java.util.*;

/**
 * Date  :  2021/1/21
 * Author:  YiPing, Wei
 * 枚举 + Kruskal + 并查集
 **/
public class P1489 {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // 初始化
        List<List<Integer>> ans = new ArrayList<>(2);
        for (int i = 0; i < 2; i++) ans.add(new LinkedList<>());
        UnionFind uf = new UnionFind(n);

        // 记录边索引
        int[][] copyEdges = new int[edges.length][4];
        for (int i = 0; i < edges.length; i++) {
            System.arraycopy(edges[i], 0, copyEdges[i], 0, 3);
            copyEdges[i][3] = i;
        }

        // 边权重升序
        Arrays.sort(copyEdges, (o1, o2) -> Integer.valueOf(o1[2]).compareTo(o2[2]));

        // 计算最小生成树的权重和
        int value = 0, v;
        for (int[] copyEdge : copyEdges) {
            if (uf.union(copyEdge[0], copyEdge[1])) {
                value += copyEdge[2];
            }
        }
        // 非联通图直接返回
        if (uf.getSize(0) < n) {
            return ans;
        }

        // 枚举所有边
        for (int i = 0; i < copyEdges.length; i++) {
            // i为关键边判定
            // 把 i 从边集里拿掉,用其他边生成最小生成树,看权重和是否和 value 一样
            v = 0;
            uf.clear();
            for (int j = 0; j < copyEdges.length; j++) {
                if (j != i && uf.union(copyEdges[j][0], copyEdges[j][1])) {
                    v += copyEdges[j][2];
                }
            }
            // 如果是关键边则跳过判伪
            if (v > value || uf.getSize(0) < n) {
                ans.get(0).add(copyEdges[i][3]);
                continue;
            }

            // i为伪关键边判定
            // 先把 i 加入生成树, 看看能否生成和 value 一样权重和的生成树
            v = copyEdges[i][2];
            uf.clear();
            uf.union(copyEdges[i][0], copyEdges[i][1]);
            for (int[] copyEdge : copyEdges) {
                if (uf.union(copyEdge[0], copyEdge[1])) {
                    v += copyEdge[2];
                }
            }
            if (v == value && uf.getSize(0) == n) {
                ans.get(1).add(copyEdges[i][3]);
            }
        }
        return ans;
    }

    private static class UnionFind {
        /**
         * parent[i]表示第i个节点的父节点
         */
        private int[] parent;

        /**
         * vector[i]表示第i个节点为根节点时的生成树顶点个数
         */
        private int[] vector;

        /**
         * 初始化size为n的并查集
         *
         * @param n 并查集大小
         */
        public UnionFind(int n) {
            parent = new int[n];
            vector = new int[n];
            clear();
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
         * 合并索引 x 和 y 的两个节点的根节点,合并了返回true,没合并返回false
         *
         * @param x 一个节点的索引
         * @param y 另一个节点的索引
         */
        public boolean union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) return false;
            parent[rootY] = rootX;
            vector[rootX] += vector[rootY];
            return true;
        }

        public boolean connected(int x, int y) {
            int rootX = find(x), rootY = find(y);
            return rootX == rootY;
        }

        /**
         * 返回根节点为 x 时候的节点数
         *
         * @param x 根节点索引
         * @return 节点数
         */
        public int getSize(int x) {
            return vector[find(x)];
        }

        public void clear() {
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                vector[i] = 1;
            }
        }
    }
}

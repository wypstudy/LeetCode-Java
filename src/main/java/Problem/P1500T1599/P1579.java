package Problem.P1500T1599;

/**
 * Date  :  2021/1/27
 * Author:  YiPing, Wei
 * ############################
 * 并查集
 * 在保证最大连通分量的情况下删除多余边,分成两个并查集计算
 * 1.考虑公共边,在并查集合并失败的情况下答案加一,合并成功另外一个并查集也合并
 * 2.考虑非公共边,各自的并查集自己合并,同样在合并失败的情况下答案加一
 * 3.如果结束上述步骤后有一个并查集的连通分量数大于1,说明不连通,否则返回答案
 **/
public class P1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int ans = 0;
        UnionFind ufa = new UnionFind(n), ufb = new UnionFind(n);
        // 节点编号从0开始,注意Java的--和++操作符只能操作一层数组,两层数组会触发装箱和拆箱导致更新的不是原来的值而是对象
        for (int[] edge:edges) {
            edge[1]--;
            edge[2]--;
        }
        // 公共边
        for (int[] edge:edges) {
            if (edge[0] == 3) {
                if (ufa.union(edge[1], edge[2])) {
                    ufb.union(edge[1], edge[2]);
                } else {
                    ++ans;
                }
            }
        }
        // 非公共边
        for (int[] edge:edges) {
            if (edge[0] == 1) {
                if (!ufa.union(edge[1], edge[2])) {
                    ++ans;
                }
            } else if (edge[0] == 2) {
                if (!ufb.union(edge[1], edge[2])) {
                    ++ans;
                }
            }
        }
        // 不连通情况处理
        if (ufa.getSize() > 1 || ufb.getSize() > 1)
            return -1;
        return ans;
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

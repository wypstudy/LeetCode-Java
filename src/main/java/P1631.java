import java.util.ArrayList;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-01-29
 *******************************************
 * 并查集 + 贪心
 * 1.先构造边列表,边长为高低差,按边长升序
 * 2.用并查集按序合并边两点,直到左上角 0,0 和 右下角 rows,cols 连通
 * 3.返回当前遍历到的最大边长
 **/
public class P1631 {
    int rows, cols, count;
    int[][] move = new int[][]{{1, 0}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        count = rows * cols;
        ArrayList<int[]> edges = new ArrayList<>();
        UnionFind uf = new UnionFind(count);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int x = i * cols + j;
                for (int[] m : move) {
                    int ni = i + m[0], nj = j + m[1];
                    if (ni < rows && nj < cols) {
                        int y = ni * cols + nj;
                        int d = Math.abs(heights[i][j] - heights[ni][nj]);
                        edges.add(new int[]{x, y, d});
                    }
                }
            }
        }
        edges.sort((a, b) -> {
            if (a[2] < b[2])
                return -1;
            else if (a[2] > b[2])
                return 1;
            return 0;
        });
        int ans = 0, first = 0, last = count - 1;
        for (int[] edge:edges) {
            if (uf.union(edge[0], edge[1]) && edge[2] > ans) {
                ans = edge[2];
            }
            // 起点和终点连通则结束
            if (uf.find(first) == uf.find(last)) break;
        }
        return ans;
    }

    static class UnionFind {
        private int[] parent;
        private int size;

        public UnionFind(int n) {
            parent = new int[n];
            size = n;
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] == x) return x;
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int xFather = find(x), yFather = find(y);
            if (xFather == yFather) return false;
            parent[yFather] = xFather;
            size--;
            return true;
        }

        public int getSize() {
            return size;
        }
    }
}

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-01-31
 *******************************************
 **/
public class P0839 {
    public int numSimilarGroups(String[] strs) {
        UnionFind uf = new UnionFind(strs.length);
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (check(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getSize();
    }

    private boolean check(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    static class UnionFind {
        int[] parent;
        int size;

        public UnionFind(int n) {
            size = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] == x) return x;
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int xf = find(x), yf = find(y);
            if (xf == yf) return false;
            parent[xf] = yf;
            size--;
            return true;
        }

        public int getSize() {
            return size;
        }
    }
}

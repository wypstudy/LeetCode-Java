package Problem.P0700T0799;

import java.util.*;

/**
 * Date  :  2021/1/18
 * Author:  YiPing, Wei
 * ########################
 * 哈希表+并查集
 **/
public class P0721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 把邮件用HashMap映射到索引和名称
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int emailIndex = 0;
        for (List<String> account:accounts) {
            String name = account.get(0);
            for (String email:account.subList(1, account.size())) {
                if (!emailToIndex.containsKey(email)) {
                    emailToName.put(email, name);
                    emailToIndex.put(email, emailIndex++);
                }
            }
        }

        // 构造并查集,同一个人的邮件合并到一起
        UnionFind uf = new UnionFind(emailIndex);
        for (List<String> account:accounts) {
            int firstEmailIndex = emailToIndex.get(account.get(1));
            for (String email:account.subList(2, account.size())) {
                int nextEmailIndex = emailToIndex.get(email);
                uf.union(firstEmailIndex, nextEmailIndex);
            }
        }

        // 用HashMap构造根节点到所有邮件的映射
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (Map.Entry<String, Integer> emailAndIndex:emailToIndex.entrySet()) {
            String email = emailAndIndex.getKey();
            Integer index = emailAndIndex.getValue();
            Integer rootIndex = uf.find(index);
            if (indexToEmails.containsKey(rootIndex)) {
                indexToEmails.get(rootIndex).add(email);
            } else {
                List<String> emails = new LinkedList<>();
                emails.add(email);
                indexToEmails.put(rootIndex, emails);
            }
        }

        // 构造答案
        List<List<String>> ans = new LinkedList<>();
        for (List<String> emails:indexToEmails.values()) {
            // 注意题目要求邮件有序
            emails.sort(String::compareTo);
            emails.add(0, emailToName.get(emails.get(0)));
            ans.add(emails);
        }
        return ans;
    }

    private static class UnionFind {
        /**
         * parent[i]表示第i个节点的父节点
         */
        private int[] parent;

        /**
         * 初始化size为n的并查集
         *
         * @param n 并查集大小
         */
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
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
        }
    }
}

package Problem.P0700T0799;

import java.util.*;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-14
 *******************************************
 * 广搜
 **/
public class P0765 {
    public int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        boolean[] vis = new boolean[n];
        int ans = 0;

        Arrays.fill(vis, false);
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new LinkedList<>();
        for (int i = 0; i < row.length; i += 2) {
            int x = row[i] / 2, y = row[i + 1] / 2;
            if (x != y) {
                graph[x].add(y);
                graph[y].add(x);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                Queue<Integer> queue = new LinkedList<>();
                vis[i] = true;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    Integer x = queue.poll();
                    for (Integer p : graph[x]) {
                        if (!vis[p]) {
                            vis[p] = true;
                            queue.offer(p);
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}

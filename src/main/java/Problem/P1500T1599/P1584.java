package Problem.P1500T1599;

import java.util.HashMap;
import java.util.Map;

/**
 * Date  :  2021/1/19
 * Author:  YiPing, Wei
 **/
public class P1584 {
    public int minCostConnectPoints(int[][] points) {
        // prim 算法初始化
        int ans = 0;
        Map<Integer, Integer> pointDistance = new HashMap<>();
        int pi = 0, px = points[pi][0], py = points[pi][1];
        for (int i = 1;i < points.length; i++) {
            int npx = points[i][0], npy = points[i][1];
            pointDistance.put(i, mhd(px, py, npx, npy));
        }

        while (!pointDistance.isEmpty()) {
            // 查找最近点
            int npi = -1, npx = 0, npy = 0, dis = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> pd:pointDistance.entrySet()) {
                if (pd.getValue() < dis) {
                    npi = pd.getKey();
                    npx = points[npi][0];
                    npy = points[npi][1];
                    dis = pd.getValue();
                }
            }

            // 更新所有点到当连通图的距离
            if (npi != -1) {
                pointDistance.remove(npi);
                ans += dis;
                for (Integer pdi:pointDistance.keySet()) {
                    int pdx = points[pdi][0], pdy = points[pdi][1], nds = mhd(npx, npy, pdx, pdy);
                    Integer pds = pointDistance.get(pdi);
                    if (nds < pds) {
                        pointDistance.put(pdi, nds);
                    }
                }
            }
        }
        return ans;
    }
    private int mhd(int ax, int ay, int bx, int by) {
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }
}

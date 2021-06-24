package Problem.P0100T0199;

import java.util.HashMap;
/**
 * Time  : 2021/6/24 18:38
 * Author: Banehallow
 */
public class P0149 {
    int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = n > 1 ? 0 : n;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            map.clear();
            for (int j = i + 1; j < n; j++) {
                int y = points[i][1] - points[j][1];
                int x = points[i][0] - points[j][0];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }
                int k = y + x * 20001;
                map.put(k, map.getOrDefault(k, 1) + 1);
            }
            for (Integer c : map.values())
                ans = c > ans ? c : ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        P0149 s = new P0149();
        int[][] d1 = new int[3][2];
        d1[0][0] = 2;
        d1[0][1] = 3;
        d1[1][0] = 3;
        d1[1][1] = 3;
        d1[2][0] = -5;
        d1[2][1] = 3;
        System.out.println(s.maxPoints(d1));
    }
}

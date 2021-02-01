package Problem.P1200T1299;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-01-17
 *******************************************
 **/
public class P1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0], y1 = coordinates[0][1], x2 = coordinates[1][0], y2 = coordinates[1][1];
        // 竖线
        if (x1 == x2) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != x1) return false;
            }
            return true;
        }
        // 横线
        if (y1 == y2) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][1] != y1) return false;
            }
            return true;
        }
        // 利用前两个点求一元一次方程的系数 a 和 b
        float a = 1.0f * (y2 - y1) / (x2 - x1), b = y1 - a * x1;
        // 判断后续点是否在这个一元一次方程的线上
        for (int i = 2; i < coordinates.length; i++) {
            if (a * coordinates[i][0] + b == coordinates[i][1]) continue;
            return false;
        }
        return true;
    }
}

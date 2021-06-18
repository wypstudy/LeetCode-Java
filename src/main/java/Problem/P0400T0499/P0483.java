package Problem.P0400T0499;

/**
 * Time  : 2021/6/18 10:43
 * Author: Banehallow
 */
public class P0483 {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(num)/Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int) Math.pow(num, 1.0/m);
            long sum = 1, pow = 1;
            for (int i = 0; i < m; i++) {
                pow *= k;
                sum += pow;
            }
            if (sum == num) {
                return Integer.toString(k);
            }
        }
        return Long.toString(num - 1);
    }
}

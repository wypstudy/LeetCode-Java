package Problem.P0100T0199;

import java.util.Arrays;

/**
 * Time  : 2021/3/29 10:29
 * Author: Banehallow
 */
public class P0190 {
    public int reverseBits(int n) {
        boolean[] bn = new boolean[32];
        Arrays.fill(bn, false);
        int i = 31;
        while (n != 0 && i >= 0) {
            bn[i] = (n & 1) == 1;
            i--;
            n >>= 1;
        }
        int ans = 0;
        for (i = 0; i < 32; i++) {
            if (bn[i]) {
                ans += 1 << i;
            }
        }
        return ans;
    }
}

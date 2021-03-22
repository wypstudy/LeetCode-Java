package Problem.P0100T0199;

/**
 * Time  : 2021/3/22 10:02
 * Author: Banehallow
 */
public class P0191 {
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) ans++;
        }
        return ans;
    }
}

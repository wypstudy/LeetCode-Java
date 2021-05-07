package Problem.P1400T1499;

/**
 * Time  : 2021/5/7 09:52
 * Author: Banehallow
 */
public class P1486 {
    public int xorOperation(int n, int start) {
        int ans = start;
        for (int i = 1; i < n; i++)
            ans ^= start + 2 * i;
        return ans;
    }
}

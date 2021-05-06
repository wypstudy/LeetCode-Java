package Problem.P1700T1799;

/**
 * Time  : 2021/5/6 10:13
 * Author: Banehallow
 */
public class P1720 {
    public int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length + 1];
        ans[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            ans[i + 1] = ans[i] ^ encoded[i];
        }
        return ans;
    }
}

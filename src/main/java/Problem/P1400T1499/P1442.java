package Problem.P1400T1499;

/**
 * Time  : 2021/5/18 11:42
 * Author: Banehallow
 */
public class P1442 {
    public int countTriplets(int[] arr) {
        int[] s = new int[arr.length + 1];
        int ans = 0;
        s[0] = 0;
        for (int i = 0; i < arr.length; i++)
            s[i + 1] = s[i] ^ arr[i];
        for (int i = 0; i < arr.length; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if (s[i] == s[k + 1]) ans += k - i;
            }
        }
        return ans;
    }
}

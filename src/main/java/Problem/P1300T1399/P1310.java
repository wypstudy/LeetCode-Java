package Problem.P1300T1399;

/**
 * Time  : 2021/5/12 09:18
 * Author: Banehallow
 */
public class P1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] xor = new int[arr.length + 1];
        xor[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            xor[i + 1] = xor[i] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            ans[i] = xor[queries[i][0]] ^ xor[queries[i][1] + 1];
        }
        return ans;
    }
}

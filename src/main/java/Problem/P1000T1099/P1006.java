package Problem.P1000T1099;

/**
 * Time  : 2021/4/1 10:03
 * Author: Banehallow
 */
public class P1006 {
    public int clumsy(int N) {
        int[] less = {0, 1, 2, 6, 7}, more = {1, 2, 2, -1};
        return N > 4 ? N + more[N % 4] : less[N];
    }
}

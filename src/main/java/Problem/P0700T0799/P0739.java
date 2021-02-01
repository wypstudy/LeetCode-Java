package Problem.P0700T0799;

/**
 * Date  :  2020/6/11
 * Author:  YiPing, Wei
 **/
public class P0739 {
    public int[] dailyTemperatures(int[] T) {
        int[] f = new int[101];
        int max = T[T.length - 1];
        for (int i = T.length - 1; i >= 0; i--) {
            int x = T[i];
            if (x > max)
                max = x;
            T[i] = f[x];
            for (int j = 30; j < x; j++)
                f[j] = 1;
            for (int j = x; j < max; j++)
                f[j]++;
        }
        return T;
    }

    public static void main(String[] args) {
        P0739 solution = new P0739();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(solution.dailyTemperatures(T));
    }
}

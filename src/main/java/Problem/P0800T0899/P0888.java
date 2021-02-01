package Problem.P0800T0899;

import java.util.HashSet;
import java.util.Set;

/**
 * Date  :  2021/2/1
 * Author:  YiPing, Wei
 **/
public class P0888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int aSum = 0, bSum = 0,eqSum;
        Set<Integer> aSet = new HashSet<>(), bSet = new HashSet<>();
        for (int i = 0; i < A.length; i++)  {
            aSum += A[i];
            aSet.add(A[i]);
        }
        for (int i = 0; i < B.length; i++) {
            bSum += B[i];
            bSet.add(B[i]);
        }
        eqSum = (aSum + bSum) / 2;

        int[] ans = new int[2];
        for (Integer a:aSet) {
            int b = eqSum - (aSum - a);
            if (bSet.contains(b)) {
                ans[0] = a;
                ans[1] = b;
            }
        }
        return ans;
    }
}

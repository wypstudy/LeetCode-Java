import java.util.*;

/**
 * Date  :  2021/1/12
 * Author:  YiPing, Wei
 * #####################
 * 模运算法则
 * (a + b) % p = (a % p + b % p) % p
 * (a - b) % p = (a % p - b % p) % p
 * (a * b) % p = (a % p * b % p) % p
 * (a ^ b) % p = ((a % b) ^ b) % p
 **/
public class P1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new LinkedList<>();
        if (A.length == 0) return ans;
        int f = A[0];
        if (f == 0)
            ans.add(true);
        else
            ans.add(false);
        for (int i = 1; i < A.length; i++) {
            f = (f * 2 + A[i]) % 5;
            if (f == 0)
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}

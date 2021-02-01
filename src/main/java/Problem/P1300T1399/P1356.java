package Problem.P1300T1399;

import java.util.*;

/**
 * Date  :  2020/11/6
 * Author:  YiPing, Wei
 * 根据二进制下1的个数排序
 **/
public class P1356 {
    /**
     * 计算原理
     * 如果一个整数不为0，那么这个整数至少有一位是1
     * 如果把一个整数减1，那么原数二进制表示的最右的1会变0，后边的0都变1，其余位置不受影响
     * 位运算与操作，同一位置都是1才会是1，否则会变成0
     * @param x 原数
     * @return 二进制下1的个数
     */
    private int count(int x) {
        int c = 0;
        while (x > 0) {
            x = x & (x - 1);
            c++;
        }
        return c;
    }

    public int[] sortByBits(int[] arr) {
        Map<Integer, Integer> oneCount = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            list.add(x);
            oneCount.put(x, count(x));
        }
        list.sort((a, b) -> {
            int cmp1 = oneCount.get(a).compareTo(oneCount.get(b));
            int cmp2 = a.compareTo(b);
            if (cmp1 != 0)
                return cmp1;
            return cmp2;
        });
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        return ans;
    }
}

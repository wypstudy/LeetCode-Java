package Problem.P1100T1199;

import java.util.Arrays;

/**
 * Date  :  2021/1/26
 * Author:  YiPing, Wei
 **/
public class P1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        // 不改变原数组,并且让牌内部升序
        int[][] copy = new int[dominoes.length][2];
        for (int i = 0; i < dominoes.length; i++) {
            if (dominoes[i][0] < dominoes[i][1]) {
                copy[i][0] = dominoes[i][0];
                copy[i][1] = dominoes[i][1];
            } else {
                copy[i][0] = dominoes[i][1];
                copy[i][1] = dominoes[i][0];
            }
        }
        Arrays.sort(copy, (o1, o2) -> {
            if (o1[0] < o2[0])
                return -1;
            else if (o1[0] > o2[0])
                return 1;
            else if (o1[1] < o2[1])
                return -1;
            else if (o1[1] > o2[1])
                return 1;
            else
                return 0;
        });
        int ans = 0, index = 0;
        while (index < copy.length) {
            // 统计有多少个相同的牌
            int[] first = copy[index];
            int nextIndex = index + 1;
            while (nextIndex < copy.length && copy[nextIndex][0] == first[0] && copy[nextIndex][1] == first[1]) {
                nextIndex++;
            }
            int count = nextIndex - index;
            // C(n,2) = n * (n-1) / 2
            ans += count * (count - 1) / 2;
            // 移动索引
            index = nextIndex;
        }
        return  ans;
    }
}

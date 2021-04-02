package Problem;

import java.util.*;

/**
 * Date  :  2020/7/8
 * Author:  YiPing, Wei
 * 《程序员面试金典(第6版)》 16.11
 **/
public class PIP16_11 {
    public int[] divingBoard(int shorter, int longer, int k) {
        Set<Integer> answerSet = new HashSet<>();
        if (k > 0) {
            for (int l = 0; l <= k; l++) {
                int s = k - l;
                answerSet.add(l * longer + s * shorter);
            }
        }
        List<Integer>  answerList = new LinkedList<>();
        answerList.addAll(answerSet);
        Collections.sort(answerList);
        int[] answer = new int[answerList.size()];
        int i = 0;
        for (Integer x : answerList)
            answer[i++] = x;
        return answer;
    }

    public static void main(String[] args) {
        PIP16_11 solution = new PIP16_11();
        solution.divingBoard(2, 1118596, 979);
    }
}

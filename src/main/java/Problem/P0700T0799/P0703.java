package Problem.P0700T0799;

import java.util.Arrays;
import java.util.Collections;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-11
 *******************************************
 * 维持一个长度为K的有序数组,使用冒泡思想
 **/
public class P0703 {
    static class KthLargest {
        private int[] list;
        private int size;
        private int index;

        public KthLargest(int k, int[] nums) {
            int len = nums.length;
            Integer[] ns = new Integer[len];
            for (int i = 0; i < len; i++) ns[i] = nums[i];
            Arrays.sort(ns, Collections.reverseOrder());
            list = new int[k];
            size = Math.min(k, len);
            for (int i = 0; i < size; i++) list[i] = ns[i];
            this.index = k - 1;
        }

        public int add(int val) {
            if (size == index || val > list[index]) {
                if (size == index) size++;
                list[index] = val;
                int i = index, tmp;
                while (i > 0 && list[i] > list[i - 1]) {
                    tmp = list[i];
                    list[i] = list[i - 1];
                    list[i - 1] = tmp;
                    i--;
                }
            }
            return list[index];
        }
    }
}

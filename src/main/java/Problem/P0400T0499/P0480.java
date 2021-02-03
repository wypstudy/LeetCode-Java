package Problem.P0400T0499;

import java.util.Arrays;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-03
 *******************************************
 * 二分查找+冒泡思想
 **/
public class P0480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];
        int[] window = Arrays.copyOf(nums, k);
        Arrays.sort(window);
        ans[0] = getMedian(window);
        for (int i = k; i < nums.length; i++) {
            // 滑动操作
            // 获取窗口左数索引
            int index = Arrays.binarySearch(window, nums[i - k]);
            // 覆盖成窗口右数
            window[index] = nums[i];
            // 比右数大则往右冒泡
            int right = index + 1;
            while (right < window.length && window[right] < window[right - 1]) {
                int tmp = window[right];
                window[right] = window[right - 1];
                window[right - 1] = tmp;
                right++;
            }
            // 比左数小往左冒泡
            int left = index - 1;
            while (left >= 0 && window[left] > window[left + 1]) {
                int tmp = window[left];
                window[left] = window[left + 1];
                window[left + 1] = tmp;
                left --;
            }
            ans[i - k + 1] = getMedian(window);
        }
        return ans;
    }

    private double getMedian(int[] sortedArr) {
        if (sortedArr.length % 2 == 0) {
            return ((double) sortedArr[sortedArr.length / 2] + (double) sortedArr[sortedArr.length/2-1]) / 2.0;
        } else {
            return sortedArr[sortedArr.length / 2];
        }
    }
}

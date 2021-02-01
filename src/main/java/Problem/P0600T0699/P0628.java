package Problem.P0600T0699;

/**
 * Date  :  2021/1/20
 * Author:  YiPing, Wei
 * 转化成问题求三个最大数和两个最小数
 * 三个最大数的乘积为其中一个可能答案
 * 二个负数和一个正数为第二个可能答案
 **/
public class P0628 {
    public int maximumProduct(int[] nums) {
        int max1 = -1001, max2 = -1001, max3 = -1001;
        int min1 = 1001, min2 = 1001;
        for (int num:nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }


    public static void main(String[] args) {
        P0628 solution = new P0628();
        int[] array = {1,2,3,2};
        System.out.println(solution.maximumProduct(array));
    }

}

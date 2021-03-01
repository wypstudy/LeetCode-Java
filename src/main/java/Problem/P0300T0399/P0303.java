package Problem.P0300T0399;

/**
 * @author yiping.wei
 * @time 2021/3/1 10:17
 */
public class P0303 {
    static class NumArray {
        int[] sum;
        public NumArray(int[] nums) {
            sum = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i > 0) {
                    sum[i] = sum[i - 1] + nums[i];
                } else {
                    sum[i] = nums[i];
                }
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return sum[j];
            } else {
                return sum[j] - sum[i - 1];
            }
        }
    }
}

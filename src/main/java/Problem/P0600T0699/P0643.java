package Problem.P0600T0699;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-04
 *******************************************
 **/
public class P0643 {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0, maxSum;
        for (int i = 0; i < k; i++) sum += nums[i];
        maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum / k;
    }
}

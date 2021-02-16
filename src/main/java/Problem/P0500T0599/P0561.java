package Problem.P0500T0599;

import java.util.Arrays;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-16
 *******************************************
 * 排序后把奇数序号的值求和
 **/
public class P0561 {
    public int arrayPairSum(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }
}

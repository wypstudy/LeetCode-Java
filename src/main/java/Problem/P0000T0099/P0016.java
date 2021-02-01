package Problem.P0000T0099;

import java.util.Arrays;

/**
 * Date  :  2020/6/23
 * Author:  YiPing, Wei
 **/
public class P0016 {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        // 枚举 a
        for (int a = 0; a < len - 2; a++) {
            if (a > 0 && nums[a] == nums[a - 1])
                continue;
            // 双指针 b 和 c,往中间靠拢
            // 当 sum > target c 左移
            // 当 sum < target b 右移
            int b = a + 1, c = len - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                if (sum == target)
                    return sum;
                if (Math.abs(sum - target) < Math.abs(ans - target))
                    ans = sum;
                if (sum > target) {
                    int tmp = nums[c];
                    while (b < c && nums[c] == tmp) c--;
                } else {
                    int tmp = nums[b];
                    while (b < c && nums[b] == tmp) b++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P0016 solution = new P0016();
        int[] nums0 = {-1, 2, 1, -4};
        int[] nums1 = {1, 1, 1, 0};
        System.out.println(solution.threeSumClosest(nums0, 1));
        System.out.println(solution.threeSumClosest(nums1, -100));
    }
}

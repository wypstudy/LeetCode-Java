package Problem.P0400T0499;

/**
 * Time  : 2021/3/24 10:15
 * Author: Banehallow
 */
public class P0456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length, min;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        // 记录从左数到 i 的最小值为 left[i]
        left[0] = nums[0];
        min = left[0];
        for (int i = 1; i < n; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            left[i] = min;
        }
        // 记录从右数到 i 的最小值为 right[i]
        right[n - 1] = nums[n - 1];
        min = right[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (min > nums[i]) {
                min = nums[i];
            }
            right[i] = min;
        }
        for (int j = 1; j < n - 1; j++) {
            if (nums[j] <= left[j - 1]) continue;
            if (nums[j] <= right[j + 1]) continue;
            for (int k = j + 1; k < n; k++) {
                if (nums[j] > nums[k] && nums[k] > left[j - 1]) return true;
            }
        }
        return false;
    }
}

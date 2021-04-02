package Problem;

/**
 * Time  : 2021/4/2 10:17
 * Author: Banehallow
 */
public class PIP17_21 {
    public int trap(int[] height) {
        int n = height.length, top;
        int[] left = new int[n], right = new int[n];

        // 假设水只会从左边漏,从左边数每个块上面能装多少水
        top = 0;
        for (int i = 0; i < n; i++) {
            left[i] = top > height[i] ? top - height[i] : 0;
            top = Math.max(height[i], top);
        }

        // 假设水只会从右边漏,从右边数每个块上面能装多少水
        top = 0;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = top > height[i] ? top - height[i] : 0;
            top = Math.max(height[i], top);
        }

        // 两边取小值
        int ans = 0;
        for (int i = 0; i < n; i++) ans += Math.min(left[i], right[i]);

        return ans;
    }
}

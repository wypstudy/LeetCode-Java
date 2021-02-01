package Problem.P0100T0199;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-01-08
 *******************************************
 **/
public class P0189 {
    // 递归模拟 + System.arraycopy优化
    private void rotate1(int[] nums, int k) {
        if (k <= 0 || nums.length <= 1) return;
        int tmp = nums[nums.length - 1];
        System.arraycopy(nums, 0, nums, 1, nums.length - 1);
        nums[0] = tmp;
        rotate1(nums, k - 1);
    }

    // 循环模拟 + System.arraycopy优化
    private void rotate2(int[] nums, int k) {
        if (k <= 0 || nums.length <= 1) return;
        for (int i = 0; i < k; i++) {
            int tmp = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = tmp;
        }
    }

    // 滚动数组
    private void rotate3(int[] nums, int k) {
        if (k <= 0 || nums.length <= 1) return;
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(newNums, 0, nums, 0, nums.length);
    }

    public void rotate(int[] nums, int k) {
        rotate1(nums, k);
    }
}

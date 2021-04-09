package Problem.P0100T0199;

/**
 * Time  : 2021/4/9 10:00
 * Author: Banehallow
 */
public class P0154 {
    public int findMin(int[] nums) {
        int i = 1;
        while (i < nums.length && nums[i] >= nums[i - 1]) i++;
        return nums[i != nums.length ? i : 0];
    }
}

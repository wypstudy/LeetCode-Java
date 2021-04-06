package Problem.P0000T0099;

/**
 * Time  : 2021/4/6 10:28
 * Author: Banehallow
 */
public class P0080 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int l = 2, r = 2;
        while (r < nums.length) {
            if (nums[l - 2] != nums[r]) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}

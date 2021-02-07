package Problem.P0600T0699;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-07
 *******************************************
 **/
public class P0665 {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) return false;
                if (i > 0 && nums[i + 1] < nums[i - 1])
                    nums[i + 1] = nums[i];
            }
        }
        return true;
    }
}

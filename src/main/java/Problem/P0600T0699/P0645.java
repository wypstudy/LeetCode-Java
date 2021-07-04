package Problem.P0600T0699;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-07-04
 *******************************************
 **/
public class P0645 {
    public int[] findErrorNums(int[] nums) {
        boolean[] v = new boolean[nums.length + 1];
        int[] ans = new int[2];
        for (int i:nums) {
            if (v[i]) {
                ans[0] = i;
            }
            v[i] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!v[i])
                ans[1] = i;
        }
        return ans;
    }
}

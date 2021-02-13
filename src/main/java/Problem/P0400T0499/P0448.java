package Problem.P0400T0499;

import java.util.ArrayList;
import java.util.List;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-13
 *******************************************
 **/
public class P0448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int num:nums) {
            int x = (num - 1) % len ;
            if (nums[x] <= len) nums[x] += len;
        }
        List<Integer> re = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) re.add(i + 1);
        }
        return re;
    }
}

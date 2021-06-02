package Problem.P0500T0599;

import java.util.HashMap;
import java.util.Map;

/**
 * Time  : 2021/6/2 17:42
 * Author: Banehallow
 */
public class P0523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> less = new HashMap<>();
        less.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int key = sum % k;
            if (less.containsKey(key)) {
                if (Math.abs(less.get(key) - (i + 1)) >=2) return true;
            } else  {
                less.put(key, i + 1);
            }
        }
        return false;
    }
}

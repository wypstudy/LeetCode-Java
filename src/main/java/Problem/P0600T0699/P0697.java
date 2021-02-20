package Problem.P0600T0699;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-20
 *******************************************
 * 哈希,记录每个出现值的第一个位置和最后一个位置
 **/
public class P0697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> buckets = new HashMap<>();
        int minLen = Integer.MAX_VALUE, k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (buckets.containsKey(nums[i])) {
                List<Integer> arr = buckets.get(nums[i]);
                arr.set(1, i);
                arr.set(2, arr.get(2) + 1);
                if (arr.get(2) == k) minLen = Math.min(minLen, arr.get(1) - arr.get(0) + 1);
                if (arr.get(2) > k) {
                    k = arr.get(2);
                    minLen = arr.get(1) - arr.get(0) + 1;
                }
            } else {
                List<Integer> arr = new ArrayList<>();
                arr.add(i);
                arr.add(i);
                arr.add(1);
                buckets.put(nums[i], arr);
                if (k == 0) {
                    minLen = 1;
                    k = 1;
                }
            }
        }
        return minLen;
    }
}

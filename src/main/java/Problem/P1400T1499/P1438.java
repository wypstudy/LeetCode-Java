package Problem.P1400T1499;


import java.util.TreeMap;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-21
 *******************************************
 * 滑动窗口 + TreeMap
 **/
public class P1438 {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> buckets = new TreeMap<>();
        int l = 0, r = 0, ans = 0;
        while (r < nums.length) {
            buckets.put(nums[r], buckets.getOrDefault(nums[r], 0) + 1);
            while (buckets.lastKey() - buckets.firstKey() > limit) {
                buckets.put(nums[l], buckets.get(nums[l]) - 1);
                if (buckets.get(nums[l]) == 0) {
                    buckets.remove(nums[l]);
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}

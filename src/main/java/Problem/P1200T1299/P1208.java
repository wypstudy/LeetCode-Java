package Problem.P1200T1299;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-05
 *******************************************
 * 双指针滑动窗口
 **/
public class P1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] cost = new int[s.length()];
        for (int i = 0; i < s.length();i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int left = 0, right = 0, sumCost = 0, ans = 0;
        while (left < s.length()) {
            // 窗口右侧滑动到不能滑为止
            while (right < s.length() && sumCost + cost[right] <= maxCost) {
                sumCost += cost[right];
                right++;
            }
            // 看看是否最长值
            ans = Math.max(ans, right - left);
            // 如果右侧已经到底,则肯定找到最长值
            if (right == s.length()) break;
            // 窗口左侧滑动,减去左值
            sumCost -= cost[left];
            left++;
        }
        return ans;
    }
}

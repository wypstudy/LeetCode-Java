package Problem.P0400T0499;

/**
 * Date  :  2021/2/2
 * Author:  YiPing, Wei
 * ****************************
 * 滑动窗口
 **/
public class P0424 {
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int len = s.length(), maxCount = 0, left = 0, right = 0;
        while (right < len) {

            // 把窗口右侧新增字符加入计数
            int charIndex = s.charAt(right)-'A';
            charCount[charIndex]++;

            maxCount = Math.max(maxCount, charCount[charIndex]);

            // 如果变换次数大于k,窗口右滑
            if (right - left - maxCount >= k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
            }

            right++;
        }
        return right - left;
    }
}

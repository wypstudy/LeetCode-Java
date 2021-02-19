package Problem.P1000T1099;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-19
 *******************************************
 * 滑动窗口
 **/
public class P1004 {
    public int longestOnes(int[] A, int K) {
        int l = 0, r = 0; // 窗口的左和右索引,窗口范围[l,r]
        int cnt = 0; // 窗口内0的个数
        int max = 0; // 最大窗口长度
        while (r < A.length) {
            while (r < A.length && cnt <= K) {
                // 窗口右侧滑动
                if (A[r] == 0) {
                    cnt++;
                }
                r++;
            }
            max = Math.max(r - l - 1, max);
            while (l < r && cnt > K) {
                // 窗口左侧滑动
                if (A[l] == 0) {
                    cnt--;
                }
                l++;
            }
            max = Math.max(r - l, max);
        }
        return max;
    }
}

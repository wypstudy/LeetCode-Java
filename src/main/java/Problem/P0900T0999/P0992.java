package Problem.P0900T0999;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-09
 *******************************************
 * 滑动窗口+排列组合思想
 **/
public class P0992 {
    private int atMostKDistinct(int[] A, int K) {
        int[] freq = new int[A.length + 1];
        int ans, left, right, count;
        ans = left = right = count = 0;
        while (right < A.length) {
            if (freq[A[right]] == 0) {
                count++;
            }
            freq[A[right]]++;
            right++;

            while (count > K) {
                freq[A[left]]--;
                if (freq[A[left]] == 0) {
                    count--;
                }
                left++;
            }
            ans += right - left;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
    }
}

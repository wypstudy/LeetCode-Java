package Problem.P0900T0999;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-18
 *******************************************
 **/
public class P0995 {
    public int minKBitFlips(int[] A, int K) {
        int ans = 0; // 真实翻转数
        int cnt = 0; // 前面连续K位的翻转奇偶性,0是偶数翻转,1是奇数翻转
        for (int i = 0; i < A.length; i++) {
            if (i >= K && A[i - K] > 1) {
                cnt ^= 1;
            }
            if (A[i] == cnt) {
                // A[i]是0时得翻转奇数次才是1
                //   所以A[i]==0时cnt==0得翻转一次
                //   所以A[i]==0时cnt==1无需翻转
                // A[i]是1时得翻转偶数次才是1
                //   所以A[i]==1时cnt==1得翻转一次
                //   所以A[i]==1时cnt==0无需翻转
                // 所以需要翻转的判断逻辑优化成 A[i]==cnt
                if (i + K > A.length) return -1; // 不够长度翻转则判定无法求解
                ans++; // 真实翻转数记数
                cnt ^= 1; // 翻转奇偶性变更
                A[i] += 2; // 记录A[i]位置经过翻转
            }
        }
        return ans;
    }
}

package Problem.P0300T0399;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-27
 *******************************************
 **/
public class P0395 {
    public int longestSubstring(String s, int k) {
        int ret = 0;
        int n = s.length();
        for (int t = 1; t <= 26; t++) {
            int l = 0, r = 0;
            int[] cnt = new int[26];
            int tot = 0;
            int less = 0;
            while (r < n) {
                int rIndex = s.charAt(r) - 'a';
                cnt[rIndex]++;
                if (cnt[rIndex] == 1) {
                    tot++;
                    less++;
                }
                if (cnt[rIndex] == k) {
                    less--;
                }

                while (tot > t) {
                    int lIndex = s.charAt(l) - 'a';
                    cnt[lIndex]--;
                    if (cnt[lIndex] == k - 1) {
                        less++;
                    }
                    if (cnt[lIndex] == 0) {
                        tot--;
                        less--;
                    }
                    l++;
                }
                if (less == 0) {
                    ret = Math.max(ret, r - l + 1);
                }
                r++;
            }
        }
        return ret;
    }
}

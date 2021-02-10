package Problem.P0500T0599;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-10
 *******************************************
 * 滑动窗口+桶记数
 **/
public class P0567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] freqS1 = new int[26], freqS2 = new int[26];
        int lenS1 = s1.length(), lenS2 = s2.length();
        for (int i = 0; i < lenS1; i++) {
            freqS1[s1.charAt(i) - 'a'] += 1;
            freqS2[s2.charAt(i) - 'a'] += 1;
        }
        if (same(freqS1, freqS2)) return true;
        for (int i = lenS1; i < lenS2; i++) {
            freqS2[s2.charAt(i - lenS1) - 'a'] -= 1;
            freqS2[s2.charAt(i) - 'a'] += 1;
            if (same(freqS1, freqS2)) return true;
        }
        return false;
    }

    private boolean same(int[] freqA, int[] freqB) {
        for (int i = 0; i < 26; i++) {
            if (freqA[i] != freqB[i]) return false;
        }
        return true;
    }
}

package Problem.P0000T0099;

/**
 * Time  : 2021/4/20 09:59
 * Author: Banehallow
 */
public class P0028 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        int max = haystack.length() - needle.length();
        for (int i = 0; i <= max; i++) {
            boolean find = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j)!=needle.charAt(j)) {
                    find = false;
                    break;
                }
            }
            if (find) return i;
        }
        return -1;
    }
}

import java.util.Arrays;

/**
 * Date  :  2020/12/18
 * Author:  YiPing, Wei
 **/
public class P0389 {
    public char findTheDifference(String s, String t) {
        char[] sa = s.toCharArray(), ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        for (int i = 0; i < s.length();i++) {
            if (sa[i]!=ta[i]) {
                return ta[i];
            }
        }
        return ta[s.length()];
    }
}

/**
 * Date  :  2020/5/28
 * Author:  YiPing, Wei
 **/
public class P0014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder re = new StringBuilder();
        int i = 0, len = strs.length, min = Integer.MAX_VALUE;
        for (int j = 0; j < strs.length; j++)
            if (strs[j].length() < min)
                min = strs[j].length();
        boolean same = true;
        while (same && i < min) {
            char first = strs[0].charAt(i);
            for (int j = 1; same && j < len;j++) {
                if (strs[j].charAt(i) != first) {
                    same = false;
                    break;
                }
            }
            if (same) {
                re.append(first);
                i++;
            }
        }
        return re.toString();
    }

    public static void main(String[] args) {
        P0014 solution = new P0014();
        String[] s1 = {"flower", "flow", "flight"};
        String[] s2 = {"dog", "racecar", "car"};
        System.out.println(solution.longestCommonPrefix(s1));
        System.out.println(solution.longestCommonPrefix(s2));
    }
}

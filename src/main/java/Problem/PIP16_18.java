package Problem;

/**
 * Date  :  2020/6/22
 * Author:  YiPing, Wei
 **/
public class PIP16_18 {
    /**
     * 循环遍历即可
     * 注意边界条件
     *   a 字符串不能与 b 字符串相同
     *   a、b字符串可以为空
     * @param pattern
     * @param value
     * @return
     */
    public boolean patternMatching(String pattern, String value) {
        if (pattern.equals("") && value.equals(""))
            return true;
        int aCount = 0, bCount = 0, pl = pattern.length(), vl = value.length();
        for (int i = 0; i < pl; i++) {
            if (pattern.charAt(i) == 'a')
                aCount++;
            else
                bCount++;
        }
        if (aCount == 0 && bCount == 0)
            return false;
        if (aCount > bCount) {
            int tmp = aCount;
            aCount = bCount;
            bCount = tmp;
            pattern = pattern.replaceAll("a", "c");
            pattern = pattern.replaceAll("b", "a");
            pattern = pattern.replaceAll("c", "b");
        }
        int aFirst = pattern.indexOf('a'), bFirst = pattern.indexOf('b');
        int aMaxLength = 0;
        if (aCount > 0)
            aMaxLength = vl / aCount;
        for (int aLength = 0; aLength <= aMaxLength; aLength++) {
            int bLength = (vl - aCount * aLength) / bCount;
            if (aLength * aCount + bLength * bCount != vl)
                continue;
            int aStart = bLength * aFirst, aEnd = aStart + aLength;
            int bStart = aLength * bFirst, bEnd = bStart + bLength;
            String a = "";
            if (aStart >= 0 && aEnd >= 0 && aStart < vl && aEnd <= vl)
                a = value.substring(aStart, aEnd);
            String b = "";
            if (bStart >= 0 && bEnd >= 0 && bStart < vl && bEnd <= vl)
                b = value.substring(bStart, bEnd);
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < pl; i++) {
                if (pattern.charAt(i) == 'a')
                    tmp.append(a);
                else
                    tmp.append(b);
            }
            if (tmp.toString().equals(value) && (!a.equals(b) || aCount == 0))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PIP16_18 solution = new PIP16_18();
        System.out.println(solution.patternMatching("abba", "dogcatcatdog"));
        System.out.println(solution.patternMatching("aaaa", "dogcatcatdog"));
        System.out.println(solution.patternMatching("abba", "dogdogdogdog"));
        System.out.println(solution.patternMatching("", "x")); //false
        System.out.println(solution.patternMatching("ab", "")); // false
        System.out.println(solution.patternMatching("a", "")); // true
        System.out.println(solution.patternMatching("aaaaab", "xahnxdxyaahnxdxyaahnxdxyaahnxdxyaauxuhuo"));
    }
}

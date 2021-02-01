package Problem.P0300T0399;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Date  :  2020/5/28
 * Author:  YiPing, Wei
 **/
public class P0394 {
    final static private List<Character> number = "0123456789".chars().mapToObj(c->(char) c).collect(Collectors.toList());

    public String decodeString(String s) {
        if (!s.contains("[")) return s;
        StringBuilder re = new StringBuilder();
        int start = 0, len = s.length();
        while (start < len) {
            if (number.contains(s.charAt(start))) {
                int end = start, bracket = 1;
                while (s.charAt(end) != '[') end++;
                int count = Integer.parseInt(s.substring(start, end));
                end++;
                start = end;
                while (bracket != 0) {
                    if (s.charAt(end) == '[') bracket += 1;
                    if (s.charAt(end) == ']') bracket -= 1;
                    end++;
                }
                String subStr = decodeString(s.substring(start, end-1));
                for (int i = 0; i < count; i++)
                    re.append(subStr);
                start = end - 1;
            } else {
                re.append(s.charAt(start));
            }
            start++;
        }
        return re.toString();
    }

    public static void main(String[] args) {
        P0394 solution = new P0394();
        System.out.println(solution.decodeString("3[a]2[bc]"));
        System.out.println(solution.decodeString("3[a2[c]]"));
        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
    }
}

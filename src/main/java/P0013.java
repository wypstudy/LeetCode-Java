import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date  :  2020/5/28
 * Author:  YiPing, Wei
 **/
public class P0013 {
    final static Map<String, Integer> ROMAN = new HashMap<String, Integer>() {{
        this.put("I", 1);
        this.put("V", 5);
        this.put("X", 10);
        this.put("L", 50);
        this.put("C", 100);
        this.put("D", 500);
        this.put("M", 1000);
        this.put("IV", 4);
        this.put("IX", 9);
        this.put("XL", 40);
        this.put("XC", 90);
        this.put("CD", 400);
        this.put("CM", 900);
    }};
    final static List<String> SPECIAL = new ArrayList<String>() {{
        this.add("IV");
        this.add("IX");
        this.add("XL");
        this.add("XC");
        this.add("CD");
        this.add("CM");
    }};

    public int romanToInt(String s) {
        int re = 0;
        for (String spe : SPECIAL) {
            if (s.contains(spe)) {
                re += ROMAN.get(spe);
                s = s.replace(spe, "");
            }
        }
        for (Character c : s.toCharArray()) {
            re += ROMAN.get(String.valueOf(c));
        }
        return re;
    }

    public static void main(String[] args) {
        P0013 solution = new P0013();
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("IX"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}

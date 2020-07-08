import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date  :  2020/7/8
 * Author:  YiPing, Wei
 **/
public class P0017 {
    private Map<Character, String> phone = new HashMap<Character, String>(){{
        this.put('2', "abc");
        this.put('3', "def");
        this.put('4', "ghi");
        this.put('5', "jkl");
        this.put('6', "mno");
        this.put('7', "pqrs");
        this.put('8', "tuv");
        this.put('9', "wxyz");
    }};
    private List<String> ans = new ArrayList<>();
    private void find (String combination, String digits) {
        if (digits.length() == 0)
            ans.add(combination);
        else {
            Character digit = digits.charAt(0);
            String next_digits = digits.substring(1);
            for (Character c:phone.get(digit).toCharArray()) {
                find(combination + c, next_digits);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        ans.clear();
        if (digits.length() > 0)
            find("", digits);
        return ans;
    }
}

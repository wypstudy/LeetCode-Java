import java.util.Map;
import java.util.TreeMap;

/**
 * Date  :  2020/12/16
 * Author:  YiPing, Wei
 * 简单题,Map存储字符查单词的字典即可
 **/
public class P0290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> ch2word = new TreeMap<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;
        for (int i = 0; i < words.length; i++) {
            Character ch = pattern.charAt(i);
            if (ch2word.containsKey(ch)) {
                if (!words[i].equals(ch2word.get(ch))) {
                    return false;
                }
            } else if (ch2word.containsValue(words[i])) {
                return false;
            } else {
                ch2word.put(ch, words[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P0290 solution = new P0290();
        System.out.println(solution.wordPattern("abba", "dog dog dog dog"));
    }
}

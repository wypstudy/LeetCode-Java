package Problem.P0100T0199;

/**
 * Date  :  2020/6/19
 * Author:  YiPing, Wei
 **/
public class P0125 {
    /**
     * 1.用正则去除标点符号
     * 2.全小写
     * 3.回文判断
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase();
        int len = s.length();
        int half = len / 2;
        for (int i = 0; i < half;i++)
            if (s.charAt(i) != s.charAt(len - i - 1))
                return false;
        return true;
    }

    public static void main(String[] args) {
        P0125 solution = new P0125();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
    }
}

/**
 * Date  :  2020/6/10
 * Author:  YiPing, Wei
 **/
public class P0009 {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String xs = String.valueOf(x);
        int i = 0, j = xs.length() - 1;
        while (i < j && xs.charAt(i) == xs.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }
    public static void main(String[] args) {
        P0009 solution = new P0009();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(22));
        System.out.println(solution.isPalindrome(-121));
    }
}

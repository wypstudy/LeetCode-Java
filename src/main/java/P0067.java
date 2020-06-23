/**
 * Date  :  2020/6/23
 * Author:  YiPing, Wei
 **/
public class P0067 {
    /**
     * 简单的高精度加法改二进制版本就行
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int c = 0, i = 0;
        StringBuilder re = new StringBuilder();
        while (i < a.length() || i < b.length() || c > 0) {
            int an = 0, bn = 0;
            if (i < a.length())
                an = a.charAt(a.length() - i - 1) - '0';
            if (i < b.length())
                bn = b.charAt(b.length() - i - 1) - '0';
            int sum = an + bn + c;
            re.insert(0, String.valueOf(sum % 2));
            c = sum / 2;
            i++;
        }
        return re.toString();
    }

    public static void main(String[] args) {
        P0067 solution = new P0067();
        System.out.println(solution.addBinary("11", "1"));
        System.out.println(solution.addBinary("1010", "1011"));
    }
}

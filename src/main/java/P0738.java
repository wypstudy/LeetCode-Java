
/**
 * Date  :  2020/12/16
 * Author:  YiPing, Wei
 **/
public class P0738 {
    public int monotoneIncreasingDigits(int N) {
        char[] array = String.valueOf(N).toCharArray();
        int i = 1;
        // 升序的部分跳过
        while (i < array.length && array[i - 1] <= array[i]) {
            i++;
        }
        // 如果一直升序不做处理
        if (i < array.length) {
            // 如果某位不升序则前一位减一,判断前一位是否升序,例如 (231 改成 220 后升序)(331 改成 200 后升序)
            while (i > 0 && array[i - 1] > array[i]) {
                array[--i]--;
            }
            // 后面的位数都补最大值 9
            for (++i; i < array.length; ++i) {
                array[i] = '9';
            }
        }
        return Integer.parseInt(new String(array));
    }
}

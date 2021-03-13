package Problem.P0300T0399;

/**
 * Time  : 2021/3/3 09:45
 * Author: Banehallow
 */
public class P0338 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];  // 记录答案
        byte[] bin = new byte[32];     // 记录当前数的二进制表示
        int oneCount = 0;              // 记录当前1的个数
        for (int i = 0; i < num; i++) {
            ans[i] = oneCount;

            // 二进制加一逻辑,在逻辑中穿插1计数的变更
            bin[0]++;
            int j = 0;
            while (j < 31 && bin[j] > 1) {
                oneCount--;     // 进位会使 1 消失
                bin[j + 1]++;   // 下一位 + 1
                bin[j] = 0;     // 当前位 = 0
                j++;            // 索引后移
            }
            oneCount++;
        }
        ans[num] = oneCount;
        return ans;
    }
}

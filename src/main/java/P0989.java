import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-01-22
 *******************************************
 **/
public class P0989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> ans = new LinkedList<>();
        int ansLen = 10001;
        int[] ansArr = new int[ansLen];
        System.arraycopy(A, 0, ansArr, ansLen - A.length, A.length);
        int j = ansLen-1;
        ansArr[j] += K;
        while (j > 0 && ansArr[j] > 9) {
            ansArr[j - 1] += ansArr[j] / 10;
            ansArr[j--] %= 10;
        }
        j = 0;
        while (j < ansLen && ansArr[j] == 0) j++;
        for (int i = j; i < ansLen; i++) ans.add(ansArr[i]);
        if (ans.size() == 0)
            ans.add(0);
        return ans;
    }
}

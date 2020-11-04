/**
 * Date  :  2020/11/3
 * Author:  YiPing, Wei
 **/
public class P0941 {
    public boolean validMountainArray(int[] A) {
        int i = 0, len = A.length, j = len - 1;
        while (i + 1 < len && A[i+1] > A[i]) i++;
        while (j - 1 >= 0 && A[j] < A[j-1]) j--;
        return i > 0 && j < len - 1 && i == j;
    }
}

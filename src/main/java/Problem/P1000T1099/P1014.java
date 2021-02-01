package Problem.P1000T1099;

/**
 * Date  :  2020/6/17
 * Author:  YiPing, Wei
 **/
public class P1014 {
    /**
     * 简单剪枝，由于A[i]最大值1000，所以走1000步以上是不划算的
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int max = 0, len = A.length;
        for (int i = 0; i < A.length - 1; i++) {
            int jMax = Math.min(i + 1000, A.length);
            for (int j = i + 1; j < jMax; j++) {
                max = Math.max(max, A[i] + A[j] + i - j);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        P1014 solution = new P1014();
        int[] A = {8,1,5,2,6};
        System.out.println(solution.maxScoreSightseeingPair(A));
    }
}

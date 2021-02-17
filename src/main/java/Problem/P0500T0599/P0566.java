package Problem.P0500T0599;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-17
 *******************************************
 **/
public class P0566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) return nums;
        int[][] reshape = new int[r][c];
        int index = 0;
        for (int[] row:nums) {
            for (int cell:row) {
                reshape[index/c][index%c] = cell;
                index++;
            }
        }
        return reshape;
    }
}

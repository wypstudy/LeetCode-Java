package Problem.P0000T0099;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-04-05
 *******************************************
 **/
public class P0088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1, i2 = n - 1, i3 = m + n - 1;
        boolean chooseLeft;
        while (i1 >= 0 && i2 >= 0) {
            chooseLeft = nums1[i1] >= nums2[i2];
            if (chooseLeft) {
                nums1[i3] = nums1[i1];
                i1--;
            } else {
                nums1[i3] = nums2[i2];
                i2--;
            }
            i3--;
        }
        while (i2 >= 0) {
            nums1[i2] = nums2[i2];
            i2--;
        }
    }
}

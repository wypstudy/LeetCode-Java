import java.util.LinkedList;
import java.util.List;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-01-10
 *******************************************
 **/
public class P0228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new LinkedList<>();
        int i = 0;
        while (i < nums.length) {
            int j = i;
            while (j+1 < nums.length && nums[j+1] == nums[j] + 1) j++;
            if (j > i) {
                ans.add(String.format("%d->%d", nums[i], nums[j]));
            } else {
                ans.add(String.valueOf(nums[i]));
            }
            i = j + 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        P0228 solution = new P0228();
        int[] nums1 = {0,1,2,4,5,7};
        System.out.println(solution.summaryRanges(nums1));
    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Date  :  2020/10/26
 * Author:  YiPing, Wei
 * 排序+Map存储计数
 **/
public class P1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int sortNums[] = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortNums);
        Map<Integer, Integer> ansMap = new HashMap<>();
        ansMap.put(sortNums[0], 0);
        for (int i = 1;i < nums.length; i++) {
            if (sortNums[i] > sortNums[i-1])
                ansMap.put(sortNums[i], i);
        }
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = ansMap.get(nums[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        P1365 solution = new P1365();
        int[] nums = {8,1,2,2,3};
        for (int i:solution.smallerNumbersThanCurrent(nums)) {
            System.out.println(i);
        }
    }
}

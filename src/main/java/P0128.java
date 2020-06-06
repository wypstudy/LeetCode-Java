import java.util.*;

/**
 * Date  :  2020/6/6
 * Author:  YiPing, Wei
 **/
public class P0128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num:nums)
            set.add(num);
        int max = 0;
        for (Integer num:set){
            if (set.contains(num - 1))
                continue;
            int count = 1;
            while (set.contains(num + count)) count++;
            if (count > max)
                max = count;
        }
        return max;
    }
    public static void main(String[] args) {
        P0128 solution = new P0128();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums));
    }
}

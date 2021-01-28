/**
 * Date  :  2021/1/28
 * Author:  YiPing, Wei
 **/
public class P0724 {
    public int pivotIndex(int[] nums) {
        if (nums.length < 3) return -1;
        int[] left = new int[nums.length], right = new int[nums.length];
        // 计算左累加
        left[0] = nums[0];
        for (int i = 1; i < nums.length; i++) left[i] = left[i - 1] + nums[i];
        // 计算右累加
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) right[i] = right[i + 1] + nums[i];
        // 判断中心索引
        if (right[1] == 0) return 0;
        for (int i = 1; i < nums.length - 1; i++)
            if (left[i - 1] == right[i + 1])
                return i;
        if (left[nums.length - 2] == 0) return nums.length - 1;
        return -1;
    }
}

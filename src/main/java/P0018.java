import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        // 空数组情况
        if (nums == null || nums.length < 4) {
            return ans;
        }
        int len = nums.length;
        Arrays.sort(nums);
        // i为枚举的第一个数的索引
        for (int i = 0; i < len - 3; i++) {
            // 第一个数去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 第一个数固定后前三个数求和都比target大直接结束
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 第一个数固定后后三个数求和都比target小枚举下一个
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                // 第二个数去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 第一个第二个数固定后前两个数求和比target大直接结束
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                // 第一个第二个数固定后后两个数求和比target小枚举下一个
                if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) {
                    continue;
                }
                int k = j + 1, h = len - 1;
                do {
                    int tmp = nums[i] + nums[j] + nums[k] + nums[h];
                    if (tmp == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[h]));
                        // 第三个数去重
                        while (k < h && nums[k] == nums[k + 1]) k++;
                        k++;
                        // 第四个数去重
                        while (k < h && nums[h] == nums[h - 1]) h--;
                        h--;
                    } else if (tmp < target) {
                        // 第三个数去重
                        while (k < h && nums[k] == nums[k + 1]) k++;
                        k++;
                    } else if (tmp > target) {
                        // 第四个数去重
                        while (k < h && nums[h] == nums[h - 1]) h--;
                        h--;
                    }
                } while (k < h);
            }
        }
        return ans;
    }
}

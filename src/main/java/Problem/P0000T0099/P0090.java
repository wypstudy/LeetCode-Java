package Problem.P0000T0099;

import java.util.*;

/**
 * Time  : 2021/3/31 10:47
 * Author: Banehallow
 */
public class P0090 {
    LinkedList<Integer> subset;
    Set<List<Integer>> ansSet;
    int[] numbers;
    int length;

    private void dfs(int index) {
        ansSet.add(new LinkedList<>(subset));
        for (int i = index + 1; i < length; i++) {
            subset.addLast(numbers[i]);
            dfs(i);
            subset.removeLast();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        subset = new LinkedList<>();
        ansSet = new HashSet<>();
        length = nums.length;
        numbers = Arrays.copyOf(nums, length);
        Arrays.sort(numbers);
        dfs(-1);
        return new ArrayList<>(ansSet);
    }
}

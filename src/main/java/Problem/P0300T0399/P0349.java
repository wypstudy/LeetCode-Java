package Problem.P0300T0399;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

/**
 * 349 两个数组的交集
 * 使用Set数据结构即可
 */
public class P0349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i:nums1)
            set1.add(i);
        for (int i:nums2)
            set2.add(i);
        List<Integer> list = new ArrayList<>();
        for (int i:set1)
            if (set2.contains(i))
                list.add(i);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        return ans;
    }
}

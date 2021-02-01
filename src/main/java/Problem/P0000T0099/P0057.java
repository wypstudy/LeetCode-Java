package Problem.P0000T0099;

import java.util.ArrayList;
import java.util.List;

/**
 * Date  :  2020/11/4
 * Author:  YiPing, Wei
 * 模拟即可,注意区间关系
 **/
public class P0057 {
    private List<Integer> array2List(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i:array)
            list.add(i);
        return list;
    }

    private int[] list2array(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size();i++)
            array[i] = list.get(i);
        return array;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> intervalsByList = new ArrayList<>();
        int len = intervals.length, index = 0;
        while (index < len && intervals[index][1] < newInterval[0]) {
            intervalsByList.add(array2List(intervals[index]));
            index++;
        }
        while (index < len && (
                (intervals[index][1] >= newInterval[0] && intervals[index][1] <= newInterval[1])
                || (intervals[index][0] >= newInterval[0] && intervals[index][0] <= newInterval[1])
                || (intervals[index][0] <= newInterval[0] && intervals[index][1] >= newInterval[1])
                || (intervals[index][0] >= newInterval[0] && intervals[index][1] <= newInterval[1])
        )) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        intervalsByList.add(array2List(newInterval));
        while (index < len) {
            intervalsByList.add(array2List(intervals[index]));
            index++;
        }
        int[][] ans = new int[intervalsByList.size()][];
        for (int i = 0; i < intervalsByList.size(); i++)
            ans[i] = list2array(intervalsByList.get(i));
        return ans;
    }
}

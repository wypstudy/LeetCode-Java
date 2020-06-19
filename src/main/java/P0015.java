import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Date  :  2020/6/19
 * Author:  YiPing, Wei
 **/
public class P0015 {
    /**
     * 三个指针a,b,c
     * 不重复条件 a==0 or nums[a] != nums[a-1]
     *          b==a+1 or nums[b] != nums[b-1]
     *          c==b+1 or nums[c] != nums[c-1]
     * 减少循环办法，先排升序，然后a从左遍历,c从右遍历，只遍历a和c中间的b，对于(0-(a+c))不在a和c中间的直接跳过
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(numList);
        int len = numList.size();
        for (int a = 0; a < len - 2; a++) {
            int c = len - 1;
            if (a == 0 || !numList.get(a).equals(numList.get(a - 1))) {
                for (int b = a + 1; b < len - 1; b++) {
                    if (b == a + 1 || !numList.get(b).equals(numList.get(b - 1))) {
                        while (c > b && numList.get(a) + numList.get(b) + numList.get(c) > 0) c--;
                        if (c > b && numList.get(a) + numList.get(b) + numList.get(c) == 0) {
                            List<Integer> answer = new ArrayList<>();
                            answer.add(numList.get(a));
                            answer.add(numList.get(b));
                            answer.add(numList.get(c));
                            re.add(answer);
                        }
                    }
                }
            }
        }
        return re;
    }
}

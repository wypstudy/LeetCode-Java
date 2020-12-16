import java.util.HashSet;

/**
 * 判断是否存在重复元素
 * 使用Set即可
 */
public class P0217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for (int i:nums) {
            if (s.contains(i))
                return true;
            s.add(i);
        }
        return false;
    }
}

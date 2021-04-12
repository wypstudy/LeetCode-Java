package Problem.P0100T0199;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Time  : 2021/4/12 10:01
 * Author: Banehallow
 */
public class P0179 {
    public String largestNumber(int[] nums) {
        String ans = Arrays.stream(nums)
                .boxed()
                .map(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.joining());
        return ans.charAt(0) != '0' ? ans : "0";
    }
}

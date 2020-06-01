import java.util.ArrayList;
import java.util.List;

/**
 * Date  :  2020/6/1
 * Author:  YiPing, Wei
 **/
public class P1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy:candies)
            if (candy > max)
                max = candy;
        List<Boolean> canMax = new ArrayList<>();
        for (int candy:candies)
            canMax.add(candy+extraCandies >= max);
        return canMax;
    }
    public static void main(String[] args) {
        P1431 solution = new P1431();
        int[] candies1 = {2,3,5,1,3};
        int[] candies2 = {4,2,1,1,2};
        int[] candies3 = {12,1,12};
        System.out.println(solution.kidsWithCandies(candies1, 3));
        System.out.println(solution.kidsWithCandies(candies2, 1));
        System.out.println(solution.kidsWithCandies(candies3, 10));
    }
}

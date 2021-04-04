package Problem.P0700T0799;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-04-04
 *******************************************
 **/
public class P0781 {
    public int numRabbits(int[] answers) {
        int[] counts = new int[1000];
        int ans = 0;
        for (int y : answers) counts[y]++;
        for (int y = 0; y < 1000; y++) {
            int x = counts[y];
            if (x > 0) ans += (x + y) / (y + 1) * (y + 1);
        }
        return ans;
    }
}

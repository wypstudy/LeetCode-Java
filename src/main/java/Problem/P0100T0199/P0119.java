package Problem.P0100T0199;

import java.util.ArrayList;
import java.util.List;

/*******************************************
 * Author:    Wei.YiPing
 * Date:      2021-02-12
 *******************************************
 **/
public class P0119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> now, pre;
        now = new ArrayList<>();
        now.add(1);
        for (int i = 0; i < rowIndex; i++) {
            pre = now;
            now = new ArrayList<>();
            now.add(1);
            for (int j = 1; j < pre.size(); j++) {
                now.add(pre.get(j-1)+pre.get(j));
            }
            now.add(1);
        }
        return now;
    }
}

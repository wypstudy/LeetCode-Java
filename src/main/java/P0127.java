import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Date  :  2020/11/5
 * Author:  YiPing, Wei
 * 模拟,集合
 * 1.一个 Set now 存储当前步数能转换的单词,初始化只包含beginWord
 * 2.一个 Set wait 存储还剩下的可转换单词,初始化包含wordList
 * 3.一个 Set next 存储下一步可转换的单词
 * 4.一个计步 Integer step 存储步数,初始化为1
 * 5.检查now和wait是不是非空,有空表示不可转换,返回0
 * 6.遍历now和wait找到所有一步可变的存入next
 * 7.wait中移除next
 * 8.next变成now
 * 9.跳到第5步一直到now中含有endWord则返回步数
 **/
public class P0127 {
    private boolean canChange(String a, String b) {
        int vote = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                vote++;
                if (vote > 1)
                    return false;
            }
        }
        return true;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> waitSet = new HashSet<>(wordList);
        Integer step = 1;
        Set<String> nowSet = new HashSet<>();
        nowSet.add(beginWord);
        while (!nowSet.contains(endWord)) {
            if (nowSet.isEmpty() || waitSet.isEmpty())
                return 0;
            Set<String> nextSet = new HashSet<>();
            for (String now : nowSet) {
                for (String next : waitSet) {
                    if (canChange(now, next)) {
                        nextSet.add(next);
                    }
                }
            }
            waitSet.removeAll(nextSet);
            nowSet = nextSet;
            step++;
        }
        return step;
    }
}

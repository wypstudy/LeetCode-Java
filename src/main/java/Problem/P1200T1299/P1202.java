package Problem.P1200T1299;

import java.util.*;

/**
 * Date  :  2021/1/11
 * Author:  YiPing, Wei
 **/
public class P1202 {
    private int findFather(int[] f, int x) {
        if (f[x] == x)
            return x;
        // 路径压缩
        f[x] = findFather(f, f[x]);
        return f[x];
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // 对关联索引构建并查集
        int[] f = new int[s.length()];
        for (int i = 0; i < s.length(); i++) f[i] = i;
        for (List<Integer> pair : pairs) {
            int aFather = findFather(f, pair.get(0));
            int bFather = findFather(f, pair.get(1));
            if (aFather < bFather) {
                f[bFather] = aFather;
            } else if (aFather > bFather) {
                f[aFather] = bFather;
            }
        }

        // 把同一个并查集的字符放进一个队列
        Map<Integer, LinkedList<Character>> chQueues = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int chIndex = findFather(f, i);
            char ch = s.charAt(i);
            LinkedList<Character> queue;
            if (chQueues.containsKey(chIndex)) {
                queue = chQueues.get(chIndex);
            } else {
                queue = new LinkedList<>();
            }
            queue.addLast(ch);
            chQueues.put(chIndex, queue);
        }

        // 对每个队列排升序
        for (int key : chQueues.keySet()) {
            LinkedList<Character> queue = chQueues.get(key);
            queue.sort(Character::compareTo);
            chQueues.put(key, queue);
        }

        // 对每个索引取同个并查集的对头元素依次存放
        char[] newChars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int chIndex = findFather(f, i);
            LinkedList<Character> queue = chQueues.get(chIndex);
            newChars[i] = queue.removeFirst();
            chQueues.put(chIndex,queue);
        }
        return String.copyValueOf(newChars);
    }

    public static void main(String[] args) {
        P1202 solution = new P1202();
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> pair00 = new ArrayList<>();
        List<Integer> pair01 = new ArrayList<>();
        pair00.add(0);
        pair00.add(3);
        pair01.add(1);
        pair01.add(2);
        pairs.add(pair00);
        pairs.add(pair01);
        System.out.println(solution.smallestStringWithSwaps("dcab", pairs));
    }
}

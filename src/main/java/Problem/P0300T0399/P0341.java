package Problem.P0300T0399;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Time  : 2021/3/23 10:22
 * Author: Banehallow
 * dfs
 */
public class P0341 {
    static interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }

    static class NestedIterator implements Iterator<Integer> {
        private List<Integer> list;
        private Iterator<Integer> iterator;


        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            dfs(nestedList);
            iterator = list.iterator();
        }

        private void dfs(List<NestedInteger> l) {
            for (NestedInteger n:l) {
                if (n.isInteger()) {
                    list.add(n.getInteger());
                } else {
                    dfs(n.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }
}

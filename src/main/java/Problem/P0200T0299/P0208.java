package Problem.P0200T0299;

/**
 * Time  : 2021/4/14 10:55
 * Author: Banehallow
 */
public class P0208 {
    class Trie {
        private Trie[] slots;
        private boolean data;

        public Trie() {
            slots = new Trie[26];
            data = false;
        }

        public void insert(String word) {
            if (word.length() == 0) {
                data = true;
                return;
            }
            int index = word.charAt(0) - 'a';
            if (slots[index] == null) {
                slots[index] = new Trie();
            }
            slots[index].insert(word.substring(1));
        }

        public boolean search(String word) {
            if (word.length() == 0) return data;
            int index = word.charAt(0) - 'a';
            if (slots[index] == null) return false;
            return slots[index].search(word.substring(1));
        }

        public boolean startsWith(String prefix) {
            if (prefix.length() == 0) return true;
            int index = prefix.charAt(0) - 'a';
            if (slots[index] == null) return false;
            return slots[index].startsWith(prefix.substring(1));
        }
    }
}

package basic.Class08;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Code02_Trie
 * @Author: 5753
 * @Date: 2022/9/11 11:32
 * @Description: TODO
 */
public class Code02_Trie {

    static class Trie {

        static  class Node {
            private int pass;
            private int end;
            private Map<Integer, Node> nexts;

            public Node() {
                pass = 0;
                end = 0;
                nexts = new HashMap<>();
            }
        }

        private Node root;

        public Trie() {
            this.root = new Node();
        }


        public void insert(String word) {
            if (word == null) {
                return;
            }
            Node node = root;
            node.pass++;
            int path = 0;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                path = chars[i];
                if (!node.nexts.containsKey(path)) {
                    node.nexts.put(path, new Node());
                }
                node = node.nexts.get(path);
                node.pass++;
            }
            node.end++;
        }

        public void erase(String word) {
            if (countWordsEqualTo(word) > 0) {
                Node node = root;
                int path = 0;
                node.pass--;
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    path = chars[i];
                    if (--node.nexts.get(path).pass == 0) {
                        node.nexts.remove(path);
                        return;
                    }
                    node = node.nexts.get(path);
                }
                node.end--;
            }


        }

        public int countWordsStartingWith(String word){
            if (word == null) {
                return 0;
            }
            Node node = root;
            int path = 0;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                path = chars[i];
                if (!node.nexts.containsKey(path)) {
                    return 0;
                }
                node = node.nexts.get(path);
            }
            return node.pass;
        }

        public int countWordsEqualTo(String word) {
            if (word == null) {
                return 0;
            }

            Node node = root;
            int path = 0;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                path = chars[i];
                if (!node.nexts.containsKey(path)) {
                    return 0;
                }
                node = node.nexts.get(path);
            }
            return node.pass;
        }


    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");               // 插入 "apple"。
        trie.insert("apple");               // 插入另一个 "apple"。
        System.out.println(trie.countWordsEqualTo("apple"));    // 有两个 "apple" 实例，所以返回 2。
        System.out.println(trie.countWordsStartingWith("app")); // "app" 是 "apple" 的前缀，所以返回 2。
        trie.erase("apple");                // 移除一个 "apple"。
        System.out.println(trie.countWordsEqualTo("apple"));    // 现在只有一个 "apple" 实例，所以返回 1。
        System.out.println(trie.countWordsStartingWith("app")); // 返回 1
        trie.erase("apple");                // 移除 "apple"。现在前缀树是空的。
        System.out.println(trie.countWordsStartingWith("app")); // 返回 0
    }


}

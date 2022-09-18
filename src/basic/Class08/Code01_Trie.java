package basic.Class08;

/**
 * @ClassName: Code01_Trie
 * @Author: 5753
 * @Date: 2022/9/11 9:41
 * @Description: TODO
 */
public class Code01_Trie {
    //单词查找树
    public static class Trie {

        public static class Node {
            private int pass;
            private int end;
            private Node[] nexts;

            public Node() {
                pass = 0;
                end = 0;
                nexts = new Node[26];
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
            char[] chars = word.toCharArray();
            Node node = root;
            node.pass++;
            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (node.nexts[path] == null) {
                    node.nexts[path] = new Node();
                }
                node = node.nexts[path];
                node.pass++;
            }
            node.end++;
        }

        public void erase(String word) {
            //先看看字符串是否存在
            if (countWordsEqualTo(word) != 0) {
                char[] chars = word.toCharArray();
                Node node = root;
                node.pass--;
                int path = 0;
                for (int i = 0; i < chars.length; i++) {
                    path = chars[i] - 'a';
                    if (--node.nexts[path].pass == 0) {
                        node.nexts[path] = null;
                        return;
                    }
                    node = node.nexts[path];
                }
                node.end --;
            }
        }

        public int countWordsStartingWith(String word){
            if (word == null) {
                return 0;
            }

            Node node = root;
            char[] chars = word.toCharArray();
            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.pass;


        }


        public int countWordsEqualTo(String word) {
            if (word == null) {
                return 0;
            }
            Node node = root;
            if (node.pass == 0) {
                return 0;
            }
            char[] chars = word.toCharArray();
            int path = 0;
            for (char aChar : chars) {
                path = aChar - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.end;
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

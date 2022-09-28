package basic.Class12;

/**
 * @ClassName: Code05_MaxSubBSTSize
 * @Author: 5753
 * @Date: 2022/9/28 9:12
 * @Description: 给定一个头节点，给两个节点a，b然后找到这两个节点的最低公共祖先。
 */
public class Code03_lowestAncestor {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info {
        private boolean findA;
        private boolean findB;
        private Node ans;

        public Info(boolean findA, boolean findB, Node ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }

    public static Info process(Node x, Node a, Node b) {
        if (x == null) return new Info(false, false, null);

        Info leftInfo = process(x.left, a, b);
        Info rightInfo = process(x.right, a, b);

        boolean findA = x == a || leftInfo.findA || rightInfo.findA;
        boolean findB = x == b || leftInfo.findB || rightInfo.findB;
        Node ans = null;

        if (leftInfo.ans != null) {
            ans = leftInfo.ans;
        }
        if (rightInfo.ans != null) {
            ans = rightInfo.ans;
        }
        if (findA && findB){
            ans = x;
        }
        return new Info(findA, findB, ans);
    }

}

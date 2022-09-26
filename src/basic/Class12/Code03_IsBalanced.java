package basic.Class12;

/**
 * @ClassName: Code03_IsBalanced
 * @Author: 5753
 * @Date: 2022/9/26 10:14
 * @Description: TODO
 */
public class Code03_IsBalanced {
    public static class Info {
        private boolean isBalance;
        private Integer height;

        public Info(boolean isBalance, Integer lh) {
            this.isBalance = isBalance;
            this.height = lh;
        }
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBalance(Node root) {
        if (root == null) return true;
        return process(root).isBalance;
    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(true,0);
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int height = Math.max(leftInfo.height , rightInfo.height) + 1;

        boolean isBalance = leftInfo.isBalance && rightInfo.isBalance && Math.abs(leftInfo.height - rightInfo.height) < 2;

        return new Info(isBalance,height);

    }


}

package basic.Class12;

import java.util.Objects;

/**
 * @ClassName: Code01_IsCBT
 * @Author: 5753
 * @Date: 2022/9/26 10:51
 * @Description: TODO
 */
public class Code01_IsCBT {
    public static class Info {
        private boolean isFull;
        private boolean isCBT;

        private Integer height;

        public Info(boolean isFull, boolean isCBT, Integer height) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
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

    public static boolean isCBT(Node root) {
        if (root == null) return true;
        return process(root).isCBT;
    }

    public static Info process(Node x) {
        if (x == null) return new Info(true, true, 0);

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        boolean isFull = leftInfo.isFull && rightInfo.isFull && Objects.equals(leftInfo.height, rightInfo.height);
        boolean isCBT = false;
        //如果左子树是完全二叉树，右子树是满二叉树，那么左子树的高度只能比右子树的高度大1
        //如果左子树是完全二叉树，右子树是完全二叉树，那么这棵树必然不是完全完全二叉树，因为当左子树不是满的情况下右子树必须得是满二叉树
        //如果右子树是完全二叉树，左子树是满二叉树，那么左子树得高度只能比右子树的高度相等
        //如果右子树是完全二叉树，左子树是完全二叉树，左右两棵树不能同时是完全二叉树
        //如果左子树是满二叉树，右子树也是满二叉树，那么左右高度差只能为1
        if (isFull) {
            isCBT = true;
        } else if (leftInfo.isCBT && rightInfo.isCBT) {
            if (leftInfo.isCBT && rightInfo.isFull && leftInfo.height -1 == rightInfo.height) isCBT = true;

            if (leftInfo.isFull && rightInfo.isCBT && leftInfo.height.equals(rightInfo.height)) isCBT = true;

            if (leftInfo.isFull && rightInfo.isFull && leftInfo.height - 1 == rightInfo.height) isCBT = true;
        }
        return new Info(isFull,isCBT,height);

    }
}

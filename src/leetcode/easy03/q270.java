package leetcode.easy03;

/**
 * @ClassName: 最接近的二叉搜索树值
 * @Author: 5753
 * @Date: 2022/9/26 17:24
 * @Description: TODO
 */
public class q270 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int closestValue(TreeNode root, double target) {
        return process(root,target);
    }

    private int process(TreeNode root, double target) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        process(root.left,target);


        process(root.right,target);

    }


}

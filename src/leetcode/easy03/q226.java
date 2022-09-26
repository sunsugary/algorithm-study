package leetcode.easy03;

/**
 * @ClassName: q226
 * @Author: 5753
 * @Date: 2022/9/25 15:13
 * @Description: TODO
 */
public class q226 {
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

    public TreeNode invertTree(TreeNode root) {
        process(root);
        return root;
    }

    private TreeNode process(TreeNode root) {
        if (root == null) return root;
        TreeNode left = process(root.left);
        TreeNode right = process(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


}

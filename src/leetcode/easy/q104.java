package leetcode.easy;

public class q104 {
    public static class TreeNode {
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

    public int maxDepth(TreeNode root) {
        return process(root);
    }

    private int process(TreeNode root) {
        if (root == null) return 0;
        return Math.max(process(root.left), process(root.right))+1;
    }
}

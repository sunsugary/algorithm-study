package leetcode.easy02;

public class q110 {
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

    public static class Info {
        private boolean isBalance;
        private Integer height;

        public Info(boolean isBalance, Integer height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root).isBalance;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info left = process(root.left);
        Info right = process(root.right);
        boolean isBalance = left.isBalance && right.isBalance && Math.abs(left.height - right.height) < 2;
        Integer height = Math.max(left.height , right.height) + 1;
        return new Info(isBalance, height);
    }
}

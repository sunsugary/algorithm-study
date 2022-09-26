package leetcode.easy02;

/**
 * @ClassName: q112
 * @Author: 5753
 * @Date: 2022/9/23 9:38
 * @Description: TODO
 */
public class q112 {
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

    public static boolean isSum = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        isSum = false;
        process(root, 0, targetSum);
        return isSum;
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;

        boolean left = hasPathSum2(root.left, targetSum - root.val);
        boolean right = hasPathSum2(root.right,targetSum - root.val);
        return left || right;
    }

    private void process(TreeNode root, int preSum, int targetSum) {

        if (root.left == null && root.right == null) {
            isSum = (preSum + root.val) == targetSum;
        }
        preSum += root.val;

        if (root.left != null) process(root.left, preSum, targetSum);
        if (root.right != null) process(root.right, preSum, targetSum);


    }
}

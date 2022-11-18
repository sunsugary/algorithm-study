package leetcode.easy05;

/**
 * @ClassName: q404
 * @Author: 5753
 * @Date: 2022/10/10 14:48
 * @Description: TODO
 */
public class q404 {
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

    public int sumOfLeftLeaves(TreeNode root) {
        return root == null ? 0 : process(root);
    }

    public int process(TreeNode x){
        int ans = 0;
        if (x.left != null){
            ans += isLeafNode(x.left)? x.left.val : process(x.left);
        }
        if (x.right != null && !isLeafNode(x.right)){
            ans += process(x.right);
        }
        return ans;

    }
    public boolean isLeafNode(TreeNode x){
        return x.left == null && x.right == null;
    }
}

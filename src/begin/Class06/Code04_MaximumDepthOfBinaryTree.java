package begin.Class06;

public class Code04_MaximumDepthOfBinaryTree {
    //测试链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree/


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


    public static int maxDepth(TreeNode root){
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

    }


}

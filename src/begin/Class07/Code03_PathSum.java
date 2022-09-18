package begin.Class07;

public class Code03_PathSum {
    // 测试链接：https://leetcode.com/problems/path-sum
    //路径和是跟节点到叶子节点的和

    //给定一个节点和一个值，返回是否能组成该路径和


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

    //定义一个全局变量，当存在达标的路径和将全局变量改为true

    public static boolean isSum = false;


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        //重置全局变量
        isSum = false;

        process(root, 0, targetSum);
        return isSum;
    }

    private void process(TreeNode root, int preSum, int targetSum) {
        //叶子节点指的是，一个节点左右节点都为空
        if (root.left == null && root.right == null) {
            //到达叶子节点
            if (targetSum == (preSum += root.val)) {
                isSum = true;
            }
        }

        preSum += root.val;
        //只有当左右节点不为空的时候才能调用递归函数
        if (root.left != null) {
            process(root.left,preSum,targetSum);
        }

        if (root.right != null) {
            process(root.right,preSum,targetSum);
        }


    }


}

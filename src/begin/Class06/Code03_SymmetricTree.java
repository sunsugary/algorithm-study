package begin.Class06;

// 测试链接：https://leetcode.cn/problems/symmetric-tree
public class Code03_SymmetricTree {

    //判断一颗二叉树是否为镜面树


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

    public boolean isSymmetric(TreeNode root) {
        return isMirrors(root,root);
    }

    public static boolean isMirrors(TreeNode node1,TreeNode node2){

        if (node1 == null ^ node2 == null) {
            return false;
        }

        if (node1 == null && node2 == null) {
            return true;
        }

        return node1.val == node2.val && isMirrors(node1.left,node2.right) && isMirrors(node1.right,node2.left);



    }


}

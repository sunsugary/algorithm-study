package begin.Class06;

public class Code02_SameTree {
// 测试链接：https://leetcode.cn/problems/same-tree

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //首先判断同个节点是否同时为空或不为空
        if (p == null ^ q == null) {
            //当pq一个空位一个不为空，则两个树不同
            return false;
        }

        //当两个节点同时为空返回true
        if (p == null && q == null) {
            return true;
        }
        //p.val == q.val
        //isSameTree(p.left,q.left)
        //isSameTree(p.right,q.right)

        return p.val == q.val &&isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {



        System.out.println(true ^ false);



    }


}

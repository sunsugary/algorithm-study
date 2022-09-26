package leetcode.easy02;

public class q100 {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return inorder(p, q);
    }

    private boolean inorder(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true; //同时为空的情况已经判断了
        if (p == null || q == null) return false;//走到这一步必然是一个为空一个不为空
        if (p.val != q.val) return false;
        return inorder(p.left, q.left) && inorder(p.right, q.right);
    }

    public static void main(String[] args) {
        Integer a = null;
        Integer b = 1;
        if (a == null || b == null) {
            System.out.println(false);
        }
    }
}

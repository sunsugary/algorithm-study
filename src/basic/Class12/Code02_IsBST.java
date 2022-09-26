package basic.Class12;


import java.util.ArrayList;

/**
 * @ClassName: Code02_IsBST
 * @Author: 5753
 * @Date: 2022/9/26 9:15
 * @Description: 二叉搜索树，每一个节点的左子树的最大值要比当前节点下，每一个节点的右子树的最小值要比当前节点大
 */
public class Code02_IsBST {
    public static class Info {
        private boolean isBst;
        private Integer max;
        private Integer min;

        public Info(boolean isBst, Integer max, Integer min) {
            this.isBst = isBst;
            this.max = max;
            this.min = min;
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root).isBst;
    }

    private static Info process(TreeNode root) {
        if (root == null) return null;
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);

        int max = root.val;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
        }
        int min = root.val;
        if (leftInfo != null){
            min = Math.min(min,leftInfo.min);
        }
        if (rightInfo != null){
            min = Math.min(min, rightInfo.min);
        }
        boolean isBst = true;
        if (leftInfo != null && !leftInfo.isBst) isBst=false;
        if (rightInfo != null && !rightInfo.isBst) isBst = false;
        if (leftInfo != null && leftInfo.max >= root.val) isBst = false;
        if (rightInfo != null && rightInfo.min <= root.val) isBst = false;
        return new Info(isBst, max, min);
    }
    public static boolean isBST1(TreeNode head) {
        if (head == null) {
            return true;
        }
        ArrayList<TreeNode> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).val <= arr.get(i - 1).val) {
                return false;
            }
        }
        return true;
    }

    public static void in(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = generateRandomBST(maxLevel, maxValue);
            if (isBST1(head) != isBST2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

    public static TreeNode generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static TreeNode generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }


}

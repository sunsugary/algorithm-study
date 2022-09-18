package begin.Class07;

public class Code05_IsBinarySearchTree {

    //一棵树是否是搜索树
    //任意一个节点的左节点比当前节点小，右节点比当前节点大
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean is, int ma, int mi) {
            isBST = is;
            max = ma;
            min = mi;
        }
    }


    public static Info process(TreeNode root){
        //由于直接判断root等于空没法返回最大值最小值
        if (root == null) {
            return null;
        }

        //这里的左右节点的info是有可能为空的
        Info leftInfo =  process(root.left);
        Info rightInfo = process(root.right);


        int max = root.val;
        int min = root.val;

        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
        }

        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }

        boolean isBST = true;

        if (leftInfo != null && leftInfo.isBST == false) {
            isBST = false;
        }

        if (rightInfo != null && rightInfo.isBST == false) {

            isBST = false;
        }

        boolean leftMaxLessRoot =  leftInfo == null ? true : leftInfo.max < root.val;
        boolean rightMinMoreRoot = rightInfo == null ? true : rightInfo.min > root.val;

        if (!(leftMaxLessRoot && rightMinMoreRoot)){
            isBST = false;
        }

        return new Info(isBST,max,min);

    }

}

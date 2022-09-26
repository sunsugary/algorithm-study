package basic.Class12;

/**
 * @ClassName: Code06_MaxDistance
 * @Author: 5753
 * @Date: 2022/9/26 9:56
 * @Description: TODO
 */
public class Code06_MaxDistance {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info {
        private Integer maxDis;
        private Integer height;

        public Info(Integer maxDis, Integer height) {
            this.maxDis = maxDis;
            this.height = height;
        }
    }

    public static int maxDistance(Node root) {
        if (root == null) return 0;
        return process(root).maxDis;
    }

    public static Info process(Node x) {
        if (x == null) return new Info(0, 0);
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int p1 = leftInfo.maxDis;
        int p2 = rightInfo.maxDis;
        int p3 = leftInfo.height + rightInfo.height + 1;
        int maxDis = Math.max(p1,Math.max(p2,p3));
        return new Info(maxDis, height);
    }





}

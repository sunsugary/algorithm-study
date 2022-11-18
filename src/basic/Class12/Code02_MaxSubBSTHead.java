package basic.Class12;

/**
 * @ClassName: Code02_MaxSubBSTHead
 * @Author: 5753
 * @Date: 2022/9/28 9:41
 * @Description: TODO
 */
public class Code02_MaxSubBSTHead {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static class Info{
        private Integer min;
        private Integer max;
        private Node maxBSTHead;
        private Integer maxBSTSize;

        public Info(Integer min, Integer max, Node maxBSTHead, Integer maxBSTSize) {
            this.min = min;
            this.max = max;
            this.maxBSTHead = maxBSTHead;
            this.maxBSTSize = maxBSTSize;
        }
    }

    public static Info process(Node x){
        if (x == null) return null;

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        Integer min = x.value;
        Integer max = x.value;
        Node maxBSTHead = null;
        Integer maxBSTSize = 0;
        if (leftInfo != null){
            min = Math.min(min,leftInfo.min);
            max = Math.max(max,leftInfo.max);
            maxBSTHead = leftInfo.maxBSTHead;
            maxBSTSize = leftInfo.maxBSTSize;
        }
        if (rightInfo != null){
            min = Math.min(min,rightInfo.min);
            max = Math.max(max,rightInfo.max);
            if (rightInfo.maxBSTSize > maxBSTSize){
                maxBSTHead = rightInfo.maxBSTHead;
                maxBSTSize = rightInfo.maxBSTSize;
            }

        }
        if ((leftInfo == null ? true : (leftInfo.maxBSTHead == x.left && leftInfo.max < x.value))
                && (rightInfo == null ? true : (rightInfo.maxBSTHead == x.right && rightInfo.min > x.value))) {
            maxBSTHead = x;
            maxBSTSize = (leftInfo == null ? 0 : leftInfo.maxBSTSize)
                    + (rightInfo == null ? 0 : rightInfo.maxBSTSize) + 1;
        }
        return new Info(min,max,maxBSTHead,maxBSTSize);
    }
}

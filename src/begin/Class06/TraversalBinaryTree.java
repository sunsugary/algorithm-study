package begin.Class06;

public class TraversalBinaryTree {
    /**
     * 二叉树遍历的三种方式
     * 1.先序遍历 ：头左右
     * 2.中序    ：左头右
     * 3.后序    ：左右头
     */
    //递归遍历

    public static class Node{
        public Integer value;
        public Node leftNode;
        public Node rightNode;
        public Node(Integer value){
            this.value = value;
        }
        public Node(Integer value,Node leftNode,Node rightNode){
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

    }

    //先序遍历
    public static void pre(Node head){
        if (head == null) {
            return;
        }
        System.out.print(head.value);
        pre(head.leftNode);
        pre(head.rightNode);
    }
    //中序遍历
    public static void in(Node head){
        if (head == null) {
            return;
        }
        in(head.leftNode);
        System.out.print(head.value);
        in(head.rightNode);

    }

    //后序遍历
    public static void pos(Node head){
        if (head == null) {
            return;
        }
        pos(head.leftNode);
        pos(head.rightNode);
        System.out.print(head.value);
    }


    public static void main(String[] args) {
        Node node = new Node(1,
                new Node(2,new Node(4,null,null),new Node(5,null,null)),
                new Node(3,new Node(6,null,null),new Node(7,null,null)));
        pre(node);
        System.out.println();
        in(node);
        System.out.println();
        pos(node);

    }
}

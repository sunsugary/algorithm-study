package begin.Demo02;

public class Code09 {

    public static class Node {
        private Integer value;
        private Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }


    public static class DoubleNode {
        private DoubleNode last;
        private DoubleNode next;

        private int value;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static DoubleNode reverseDoubleLinked(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }

        return pre;


    }

    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;

        while (head != null) {
            /*
              记录head指向的下一个节点
             */
            next = head.next;
            //因为head要变成最后一个所以将head的下一个指针变为只想null
            head.next = pre;

            pre = head;

            head = next;


        }

        return pre;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        n1 = reverseLinkedList(n1);

    }
}

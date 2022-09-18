package basic.Class02;

import java.util.ArrayList;
import java.util.List;

public class Code01_ReverseList {

    //反转单链表
    public static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public static class DoubleNode<T> {
        private T value;
        private DoubleNode<T> last;
        private DoubleNode<T> next;

        public DoubleNode(T value) {
            this.value = value;
        }
    }

    //反转双端链表
    public static DoubleNode<Integer> reverseDoubleLinkedList(DoubleNode<Integer> head) {
        DoubleNode<Integer> pre = null;
        DoubleNode<Integer> last = null;
        DoubleNode<Integer> next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 使用有限变量实现链表的反转
     *
     * @param head 头节点
     * @return Node 反转之后的头节点
     */
    public static Node<Integer> reverseLinkedList(Node<Integer> head) {
        Node<Integer> pre = null;
        Node<Integer> next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    /**
     * 使用容器的方式反转单链表
     *
     * @param head 头节点
     * @return Node 反转之后的头节点
     */
    public static Node<Integer> reverseLinkedList2(Node<Integer> head) {
        if (head == null) {
            return null;
        }

        List<Node<Integer>> nodeList = new ArrayList<>();

        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }

        nodeList.get(0).next = null;

        for (int i = nodeList.size() - 1; i > 0; i--) {
            nodeList.get(i).next = nodeList.get(i - 1);
        }
        return nodeList.get(nodeList.size() - 1);
    }

    /**
     * 生成随机单链表作为对数器
     *
     * @param len   链表的长度范围
     * @param value 链表数值范围
     * @return Node
     */
    public static Node<Integer> generateLinkedList(int len, int value) {
        //随机一个不为0的数作为链表长度
        int size = (int) (Math.random() * (len + 1)) + 1;
        //随机一个头节点
        Node<Integer> head = new Node<>((int) (Math.random() * (value + 1)));
        Node<Integer> ans = head;
        size--;
        while (size > 0) {
            Node<Integer> cur = new Node<Integer>((int) (Math.random() * (value + 1)));
            head.next = cur;
            size--;
            head = cur;
        }
        return ans;

    }

    /**
     * 生成随机双链表作为对数器
     *
     * @param len   链表的长度范围
     * @param value 链表数值范围
     * @return Node
     */
    public static DoubleNode<Integer> generateDoubleLinkedList(int len, int value) {
        //随机一个不为0的数作为链表长度
        int size = (int) (Math.random() * (len + 1)) + 1;
        //随机一个头节点
        DoubleNode<Integer> head = new DoubleNode<>((int) (Math.random() * (value + 1)));
        DoubleNode<Integer> ans = head;
        size--;
        while (size > 0) {
            DoubleNode<Integer> cur = new DoubleNode<Integer>((int) (Math.random() * (value + 1)));
            head.next = cur;
            cur.last = head;
            size--;
            head = cur;
        }
        return ans;

    }

    public static void printNode(Node head) {
        if (head == null) {
            return;
        }
        while (head.next != null) {
            System.out.print(head.value + ",");
            head = head.next;
        }
        System.out.println();
    }

    public static List<Node<Integer>> getLinkedListOriginOrder(Node<Integer> node) {
        List<Node<Integer>> ans = new ArrayList<>();
        while (node != null) {
            ans.add(node);
            node = node.next;
        }
        return ans;
    }

    public static List<Integer> getDoubleListOriginOrder(DoubleNode<Integer> head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    public static boolean checkDoubleListReverse(List<Integer> origin, DoubleNode<Integer> head) {
        //定义一个变量找出末尾节点，然后从末尾节点遍历
        DoubleNode<Integer> end = null;

        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            end = head;
            head = head.next;
        }

        for (int i = 0; i < origin.size(); i++) {
            if (!origin.get(i).equals(end.value)) {
                return false;
            }
            end = end.last;
        }
        return true;
    }


    public static void main(String[] args) {

        int len = 500;
        int value = 1000;
        int testTime = 100000;
        System.out.println("test begin!");
        for (int i = 0; i < testTime; i++) {
            Node<Integer> node1 = generateLinkedList(len, value);
            List<Node<Integer>> list1 = getLinkedListOriginOrder(node1);
            node1 = reverseLinkedList(node1);
            if (checkLinkedListReverse(list1, node1)) {
                System.out.println("Oops1!");
            }
            Node<Integer> node2 = generateLinkedList(len, value);
            List<Node<Integer>> list2 = getLinkedListOriginOrder(node2);
            node2 = reverseLinkedList2(node2);
            if (checkLinkedListReverse(list2, node2)) {
                System.out.println("Oops2!");
            }

            DoubleNode<Integer> node3 = generateDoubleLinkedList(len, value);
            List<Integer> list3 = getDoubleListOriginOrder(node3);
            node3 = reverseDoubleLinkedList(node3);
            if (!checkDoubleListReverse(list3,node3)) {
                System.out.println("Oops3!");
            }

        }
        System.out.println("test end!");


    }

    private static boolean checkLinkedListReverse(List<Node<Integer>> list1, Node<Integer> node1) {
        for (int i = list1.size() - 1; i > 0; i--) {
            if (list1.get(i).value != node1.value.intValue()) {
                return true;
            }
            node1 = node1.next;
        }
        return false;
    }

}

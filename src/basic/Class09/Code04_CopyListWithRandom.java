package basic.Class09;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Code04_CopyListWithRandom
 * @Author: 5753
 * @Date: 2022/9/18 13:19
 * @Description: 一个链表每个节点都有两个指针，一个指针为next指针指向下一个节点，另外一个指针指向链表所有节点随机一个节点。
 * 拷贝原链表的结构。使用容器与不使用容器各完成一遍。
 */
public class Code04_CopyListWithRandom {
    public static class Node {
        private int val;
        private Node next;
        private Node random;

        public Node(int value) {
            this.val = value;
        }
    }

    //使用容器的方式拷贝原链表
    public static Node copyRandomList1(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        Node p2 = head;
        while (p2 != null) {
            map.get(p2).next = map.get(p2.next);
            map.get(p2).random = map.get(p2.random);
            p2 = p2.next;
        }
        return map.get(head);
    }

    //不适用容器的方式，将每一个新节点连接在老节点后面
    public static Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            Node newNode = new Node(cur.val);
            cur.next = newNode;
            newNode.next = next;
            cur = next;
        }
        // n1 -> n2 -> n3
        // n1 -> n1` -> n2 -> n2` -> n3 -> n3`
        cur = head;
        Node copy = null;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            //并不是所有的节点random都指向有节点
            copy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }

        Node ans = head.next;

        cur = head;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next != null ? next.next : null;
            cur = next;

        }
        return ans;


    }


}

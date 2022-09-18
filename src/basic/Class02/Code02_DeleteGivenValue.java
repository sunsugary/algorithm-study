package basic.Class02;

public class Code02_DeleteGivenValue {
    //1.给定一个链表的头节点，和一个值，删除链表中所有等于该值的节点，返回新头节点。

    public static class Node {
        private Integer value;
        private Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public static Node removeValue(Node head, int value) {
        //便利所有节点返回第一个不等于要删除的节点
        while (head != null) {
            if (head.value != value) {
                break;
            }
            head = head.next;
        }
        //定义一个指针记住上一个节点
        Node pre = head;
        Node cur = head;
        while (cur != null){
            if (cur.value == value) {
                //当前节点的值如果等于要删除的值，则跳过当前值
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }

        return head;

    }
}

package basic.Class09;

/**
 * @ClassName: Code01_LinkedListMid
 * @Author: 5753
 * @Date: 2022/9/18 8:44
 * @Description: 1）如果个数是奇数个，返回中点；
 * 2）如果是偶数个返回上中点；
 * 3）如果是偶数个返回下中点；
 * 4）如果是奇数返回中点的前一个；
 * 5）如果是偶数个返回下中点的前一个；
 */
public class Code01_LinkedListMid {
    public static class Node {
        private Integer value;
        private Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }

    //使用快慢指针 如果是偶数个返回的是上中点，如果是奇数个返回中点
    public static Node listMid(Node head) {
        //快指针一次走两步，慢指针一次走一步
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        //链表必须要大于或等于三个
        //定义两个指针，由于已经判断了链表此时必然大于或等于3，所以定义两个指针都走过了一步
        Node slow = head.next;
        Node fast = head.next.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //如果是偶数个返回的是上中点，如果是奇数个返回中点
        return slow;
    }

    //如果是偶数个返回的是上中点，如果是奇数个返回中点
    public static Node downMid(Node head) {
        if (head == null || head.next == null ) {
            return null;
        }
        if (head.next.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //偶数个返回上中点的前一个 奇数个返回中点的前一个
    public static Node preMid(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //


}

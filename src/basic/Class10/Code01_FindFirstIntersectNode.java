package basic.Class10;

/**
 * @ClassName: Code01_FindFirstIntersectNode
 * @Author: 5753
 * @Date: 2022/9/18 15:02
 * @Description: 分析问题：
 * 1.首先判断两个链表是否有环，并返回入环节点
 * 2.如果两个链表都无环，那么两个链表的尾节点一定相同，找到第一个相交的节点
 * 3.两个链表如果一个有环，一个无环，不可能相交
 * 4.如果两个链表都有环，此时有三种情况：
 * 情况1：两个链表不相交
 * 情况2：两个链表在入环之前相交，那么两个链表的入环节点一定相同
 * 情况3：两个链表在入环之后相交，那么就有两个相交点
 * 1.如果一个链表有环，定义两个指针，快指针fast一次走两步，慢指针slow一次走一步，
 * 当两个指针相等时，将快指针重新指向头，然后一次走一步，最终快慢指针相等，此时则为相交节点
 * 2.如果两个无环的链表，如果相交，那么尾节点一定相同。然后让长链表先走两个链表的差值步数，两个指针依次走一步，相等时则为第一个相交节点。
 */
public class Code01_FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        if (loop1 == null && loop2 == null) {
            //两个链表都没有环
            return noLoop(head1, head2);
        }

        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    //两个链表都有环 分为三种情况：
    //1.没有交点
    //2.在入环之前有交点 此时两个链表的入环节点一定相同
    //3.在入环之后有交点
    private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = head1;
        Node cur2 = head2;
        if (loop1 == loop2) {
            //入环之前有节点
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }

            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;

            n = Math.abs(n);

            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }

            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;


        }else{
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    //两个链表都没有环
    private static Node noLoop(Node head1, Node head2) {
        Node cur1 = head1;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        Node cur2 = head2;
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }

        if (cur1 != cur2) {
            //两个没有环的链表如果尾节点不相同，则一定没有交点
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;

        //此时得到的cur1就是长链表，cur2就是短链表
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        //此时的cur1就是除掉了差值

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //找入环点
    private static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                //快指针能走到空，说明链表没有环
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //得到两个指针第一次相交的节点

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;


    }
    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        //无环有相交
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        //有环 在入环前相交
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        //有环 在入环后相交
        System.out.println(getIntersectNode(head1, head2).value);

    }

}

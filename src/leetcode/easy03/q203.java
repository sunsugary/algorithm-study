package leetcode.easy03;

/**
 * @ClassName: q203
 * @Author: 5753
 * @Date: 2022/9/25 9:17
 * @Description: TODO
 */
public class q203 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return null;
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val != val){
                pre.next = cur;
                pre = cur;
            }
            cur =cur.next;
        }
        pre.next = null;
        return head;
    }

        public ListNode removeElements2(ListNode head, int val) {
            if (head == null) {
                return head;
            }
            head.next = removeElements2(head.next,val);
            return head.val == val ? head.next : head;
        }

    public ListNode removeElements3(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = newHead;
        while (cur.next != null){
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}

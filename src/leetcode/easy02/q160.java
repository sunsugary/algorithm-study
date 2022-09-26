package leetcode.easy02;

/**
 * @ClassName: q160
 * @Author: 5753
 * @Date: 2022/9/24 10:50
 * @Description: TODO
 */
public class q160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode cur = headA;
        int l1 = 1;
        int l2 = 1;
        while (cur.next != null) {
            l1++;
            cur = cur.next;
        }
        ListNode cur2 = headB;
        while (cur2.next != null) {
            l2++;
            cur2 = cur2.next;
        }
        if (cur != cur2) return null;

        cur = l1 > l2 ? headA : headB;
        cur2 = cur == headA ? headB : headA;
        int n = Math.abs(l1 - l2);
        while (n != 0) {
            cur = cur.next;
            n--;
        }

        while (cur != cur2) {
            cur = cur.next;
            cur2 = cur2.next;
        }
        return cur;
    }
}

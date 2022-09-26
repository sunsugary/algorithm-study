package leetcode.easy02;

/**
 * @ClassName: q141
 * @Author: 5753
 * @Date: 2022/9/23 17:43
 * @Description: TODO
 */
public class q141 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast.next == null || fast.next.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

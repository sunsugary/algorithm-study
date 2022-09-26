package leetcode.easy01;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: q83
 * @Author: 5753
 * @Date: 2022/9/22 16:51
 * @Description: TODO
 */
public class q83 {
    public static class ListNode {
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

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(1);
        node1.next.next = new ListNode(2);
        node1.next.next.next = new ListNode(3);
        node1.next.next.next.next = new ListNode(3);
        ListNode listNode = deleteDuplicates2(node1);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(head.val, 1);
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (!map.containsKey(cur.val)) {
                map.put(cur.val, 1);
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;
        }
        pre.next = null;
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}

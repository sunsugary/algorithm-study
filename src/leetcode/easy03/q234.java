package leetcode.easy03;

import java.util.Stack;

/**
 * @ClassName: q234
 * @Author: 5753
 * @Date: 2022/9/25 18:04
 * @Description: TODO
 */
public class q234 {
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

    public boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            if (cur.val != stack.pop().val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        //快慢指针法
        ListNode slow = head;
        ListNode fast = head;

        while ( fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //此时如果是奇数 慢指针刚好是中点
        //   如果是偶数 慢指针是上中点

        //开始单链表的反转
        ListNode cur = slow.next;
        slow.next = null;
        ListNode pre = slow;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur = head;
        ListNode cur2 = pre;
        //此时pre就是尾部的头
        boolean ans = true;
        while (cur != null && cur2 != null){
            if (cur.val != cur2.val) {
                ans = false;
                break;
            }
            cur = cur.next;
            cur2 = cur2.next;
        }

        //将链表复原
        cur2 = pre;
        pre = null;
        next = null;
        while (cur2 != null){
            next = cur2.next;
            cur2.next = pre;
            pre = cur2;
            cur2 = next;
        }
        return ans;
    }



}


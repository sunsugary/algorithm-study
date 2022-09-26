package basic.Class10;

import java.util.Stack;

/**
 * @ClassName: Code03_UnRecursiveTraversalBT
 * @Author: 5753
 * @Date: 2022/9/20 16:59
 * @Description: 非递归方式遍历实现二叉树的先中后遍历
 */
public class Code03_UnRecursiveTraversalBT {
    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //先序遍历
    public static void pre(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value);
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    //非递归完成中序遍历
    public static void in(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (!stack.isEmpty() || cur != null) {
            if (cur.left != null) {
                stack.push(cur.left);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.println(cur.value);
                cur = cur.right;
            }
        }
    }

    //非递归完成后序遍历
    public static void last(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        Node cur = null;
        while (!s1.isEmpty()) {
            cur = s1.pop();
            s2.push(cur);
            if (cur.left != null) s1.push(cur.left);
            if (cur.right != null) s1.push(cur.right);
        }

        while (!s2.isEmpty()){
            System.out.println(s2.pop());
        }


    }


}

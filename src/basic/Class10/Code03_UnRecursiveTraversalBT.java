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
        if (head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value);
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }
    //


}

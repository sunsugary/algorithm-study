package basic.Class11;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: Code02_SerializeAndReconstructTree
 * @Author: 5753
 * @Date: 2022/9/23 21:39
 * @Description: 二叉树可以通过先序，后序，按层遍历来实现序列化与反序列化，但是无法通过中序
 */
public class Code02_SerializeAndReconstructTree {
    //先序遍历序列化
    public static class Node {
        private Integer val;
        private Node left;
        private Node right;

        public Node(Integer val) {
            this.val = val;
        }
    }

    public static Queue<String> preSerial(Node root) {
        Queue<String> queue = new LinkedList<>();
        pres(queue, root);
        return queue;
    }

    private static void pres(Queue<String> queue, Node root) {
        if (root == null) {
            queue.add(null);
        } else {
            queue.add(String.valueOf(root.val));
            pres(queue, root.left);
            pres(queue, root.right);
        }
    }

    public static Node reversePreSerial(Queue<String> queue) {
        if (queue == null || queue.isEmpty()) return null;
        return reversePreS(queue);

    }

    private static Node reversePreS(Queue<String> queue) {
        String val = queue.poll();
        if (val == null) return null;

        Node node = new Node(Integer.valueOf(val));
        node.left = reversePreS(queue);
        node.right = reversePreS(queue);
        return node;
    }

    public static Queue<String> levelSerial(Node root) {
        if (root == null) {
            return null;
        }
        Queue<String> ans = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        ans.add(root.val.toString());
        Node cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left != null) {
                ans.add(String.valueOf(cur.left.val));
                queue.add(cur.left);
            } else {
                ans.add(null);
            }
            if (cur.right != null) {
                ans.add(String.valueOf(cur.right.val));
                queue.add(cur.right);
            } else {
                ans.add(null);
            }
        }
        return ans;
    }

    public static Node generateNode(String val) {
        if (val == null) {
            return null;
        }
        return new Node(Integer.valueOf(val));
    }

    public static Node reverseLevelS(Queue<String> queue) {
        Queue<Node> help = new LinkedList<>();
        if (queue == null || queue.isEmpty()) {
            return null;
        }
        Node head = generateNode(queue.poll());
        if (head != null){
            help.add(head);
        }
        Node cur = null;
        while (!help.isEmpty()) {
            cur = help.poll();
            cur.left = generateNode(queue.poll());
            cur.right = generateNode(queue.poll());
            if (cur.left != null){
                help.add(cur.left);
            }
            if (cur.right !=null){
                help.add(cur.right);
            }
        }
        return head;
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        Queue<String> strings = levelSerial(node);
        while (!strings.isEmpty()) {
            System.out.print(strings.poll() + " ,");
        }

//        Node node1 = reversePreSerial(strings);

    }


}

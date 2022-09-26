package basic.Class11;

import java.util.List;

/**
 * @ClassName: Code03_EncodeNaryTreeToBinaryTree
 * @Author: 5753
 * @Date: 2022/9/24 9:21
 * @Description: TODO
 */
public class Code03_EncodeNaryTreeToBinaryTree {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode encode(Node root){
        TreeNode head = new TreeNode(root.val);
        head.left = en(root.children);
        return head;
    }

    private static TreeNode en(List<Node> children) {
        TreeNode head = null;
        TreeNode cur = null;
        for (Node child : children) {
           TreeNode tNode = new TreeNode(child.val);
           if (head == null){
                head = tNode;
           }else{
               cur.right = tNode;
           }
            cur = tNode;
            cur.left = en(child.children);
        }
        return head;
    }


}

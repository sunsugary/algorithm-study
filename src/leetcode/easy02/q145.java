package leetcode.easy02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: q145
 * @Author: 5753
 * @Date: 2022/9/24 10:05
 * @Description: TODO
 */
public class q145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(ans, root);
        return ans;

    }

    private void postorder(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        TreeNode cur = null;
        while (!s1.isEmpty()) {
            cur = s1.pop();
            s2.push(cur);
            if (cur.left != null) {
                s1.push(cur.left);
            }
            if (cur.right != null) {
                s1.push(cur.right);
            }
        }
        while (!s2.isEmpty()) {
            ans.add(s2.pop().val);
        }
    }


}

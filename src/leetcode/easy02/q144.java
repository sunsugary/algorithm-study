package leetcode.easy02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: q144
 * @Author: 5753
 * @Date: 2022/9/24 9:54
 * @Description: TODO
 */
public class q144 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode cur = null;
        while (!stack.isEmpty()){
            cur = stack.pop();
            ans.add(cur.val);
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null ){
                stack.push(cur.left);
            }

        }
        return ans;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        prorder(ans,root);
        return ans;
    }

    private void prorder(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        prorder(ans,root.left);
        prorder(ans,root.right);

    }


}

package leetcode.easy03;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: q257
 * @Author: 5753
 * @Date: 2022/9/26 14:09
 * @Description: TODO
 */
public class q257 {
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        process(root, "", ans);
        return ans;
    }

    private void process(TreeNode x, String path, List<String> ans) {
        if (x == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(path);
        sb.append(x.val);
        if (x.left == null && x.right == null) {
            ans.add(sb.toString());
        } else {
            sb.append("->");
            process(x.left, sb.toString(), ans);
            process(x.right, sb.toString(), ans);
        }
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> output = new ArrayList<>();
        findPaths(root, output, "");
        return output;
    }

    private void findPaths(TreeNode root, List<String> output, String currPath) {
        if (root == null) {
            return;
        }

        if (!currPath.isEmpty()) {
            currPath += "->";
        }
        currPath += root.val;

        if (root.left == null && root.right == null) {
            output.add(currPath);
            return;
        }

        findPaths(root.left, output, currPath);
        findPaths(root.right, output, currPath);
    }


    public List<String> binaryTreePathsBackTrack(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb);
        return res;
    }

    private void helper(List<String> res, TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(res, root.left, sb);
            helper(res, root.right, sb);
        }
        sb.setLength(len);
    }
}

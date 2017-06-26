package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/#/description

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as
the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
 Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */
public class LowestCommonAncestor {

    // TODO: Write code for when a binary search tree

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       return lca(root, p, q);
       // would use containsNodes if p and q not guaranteed in tree, but here they are
    }

    private TreeNode lca(TreeNode root, TreeNode first, TreeNode second) {

        if (root == null || root == first || root == second) {
            return root;
        }

        TreeNode left = lca(root.left, first, second);
        TreeNode right = lca(root.right, first, second);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }


    private boolean containsNodes(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        boolean foundP = false;
        boolean foundQ = false;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.equals(p)) {
                foundP = true;
            } else if (curr.equals(q)) {
                foundQ = true;
            }

            if (foundP && foundQ) {
                return true;
            }

            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        return false;
    }
}

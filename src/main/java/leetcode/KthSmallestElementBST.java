package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/kth-smallest-element-in-a-bst/#/description
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ? k ? BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        return values.get(k-1);
    }

    private void inorder(TreeNode root, List<Integer> values) {
        if (root != null) {
            if (root.left != null) {
                inorder(root.left, values);
            }
            values.add(root.val);
            if (root.right != null) {
                inorder(root.right, values);
            }
        }
    }
}

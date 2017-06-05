package leetcode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/#/description
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + ((end - start) / 2);

        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildTree(nums, start, mid-1);
        root.right = buildTree(nums, mid+1, end);
        return root;
    }

}

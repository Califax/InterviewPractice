package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreePathsAddingToTarget {

    /*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, 0, new ArrayList<>(new ArrayList<>()), new ArrayList<>());
    }

    List<List<Integer>> pathSum(TreeNode root, int target, int currSum, List<List<Integer>> output, List<Integer> currPath) {

        if (root == null) {
            return output;
        }

        currPath.add(root.val);
        currSum += root.val;

        if (root.left == null & root.right == null) {
            if (currSum == target) {
                List<Integer> copy = new ArrayList<>(currPath);
                output.add(copy);
            }
            currPath.remove(currPath.size() - 1); // remove the current node
            return output;
        }

        if (root.left != null) {
            pathSum(root.left, target, currSum, output, currPath);
        }
        if (root.right != null) {
            pathSum(root.right, target, currSum, output, currPath);
        }

        currPath.remove(currPath.size() - 1);

        return output;
    }

    // Path sum 2 makes copies of the array which is less efficient
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        return pathSum(root, sum, 0, new ArrayList<>(Collections.emptyList()), new ArrayList<>());
    }

    List<List<Integer>> pathSum2(TreeNode root, int target, int currSum, List<List<Integer>> output, List<Integer> currPath) {

        if (root == null) {
            return output;
        }

        currSum += root.val;

        List<Integer> copy = new ArrayList<>(currPath);

        if (root.left == null && root.right == null) {
            if (currSum == target) {
//        List<Integer> copy = new ArrayList<>(currPath);
                copy.add(root.val);
                output.add(copy);
            }
            return output;
        }

//    List<Integer> copy = new ArrayList<>(currPath);
        copy.add(root.val);

        pathSum(root.left, target, currSum, output, copy);
        pathSum(root.right, target, currSum, output, copy);

        return output;
    }
}

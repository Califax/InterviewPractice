package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/#/description
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 */
public class SerializeDeserializeBinaryTree {

    private static final String DELIM = " ";
    private static final String SENTINAL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return SENTINAL;
        } else {
            StringBuilder serialized = new StringBuilder();
            serialize(root, serialized);
            return serialized.toString();
        }
    }

    private void serialize(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append(SENTINAL).append(DELIM);
        } else {
            str.append(root.val).append(DELIM);
            serialize(root.left, str);
            serialize(root.right, str);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, data.split(DELIM));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String curr = queue.poll();

        if (SENTINAL.equals(curr)) {
            return null;
        }

        TreeNode currNode = new TreeNode(Integer.valueOf(curr));
        currNode.left = deserialize(queue);
        currNode.right = deserialize(queue);
        return currNode;
    }
}

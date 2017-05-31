package recurrsion;

public class CountPathsInBinaryTreeAddingToTarget {
    /*

  // Paths summing to target
  //Target: 5
  //    2
  //   / \
  //  3  -3
  // /  /  \
  //1  8    6
  //         \
  //         -1
  //           \
  //            1
  //             \
  //              0

  //Return Val: 4
 */
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(2);
        Node<Integer> leftOfRoot = new Node<>(3);
        Node<Integer> rightOfRoot = new Node<>(-3);
        Node<Integer> rightOfRight = new Node<>(6);
        Node<Integer> leftOfRight = new Node<>(8);
        Node<Integer> leftOfLeft = new Node<>(1);
        Node<Integer> rightOfRightOfRight = new Node<>(-1);
        rightOfRight.right = rightOfRightOfRight;
        Node<Integer> rightOfRightOfRightOfRight = new Node<>(1);
        rightOfRightOfRight.right = rightOfRightOfRightOfRight;
        Node<Integer> rightOfRightOfRightOfRightRight = new Node<>(0);
        rightOfRightOfRightOfRight.right = rightOfRightOfRightOfRightRight;

        root.left = leftOfRoot;
        root.right = rightOfRoot;
        leftOfRoot.left = leftOfLeft;
        rightOfRoot.right = rightOfRight;
        rightOfRoot.left = leftOfRight;

        int numPaths = getNumPaths(root, 5);
        System.out.println(numPaths);
    }

    static int getNumPaths(Node<Integer> root, int target) {
        return getNumPaths(root, 0, target);
    }

//  private static int getNumPaths(Node<Integer> root, int currSum, int target) {
//
//    if (root == null) {
//      return 0;
//    }
//
//    if (currSum + root.val == target) {
//      return 1 +
//          getNumPaths(root.left, currSum + root.val, target) + getNumPaths(root.right, currSum +root.val, target);
//    }
//
//    return getNumPaths(root.left, currSum + root.val, target) + getNumPaths(root.right, currSum +root.val, target);
//  }

    private static int getNumPaths(Node<Integer> root, int currSum, int target) {

        int totalPaths = 0;

        if (root == null) {
            return totalPaths;
        }

        currSum += root.val;

        if (currSum == target) {
            totalPaths++;
        }

        totalPaths += getNumPaths(root.left, currSum, target);
        totalPaths += getNumPaths(root.right, currSum, target);
        return totalPaths;
    }

    private static class Node<T> {
        T val;
        Node left;
        Node right;

        Node(T val) {
            this.val = val;
        }
    }
}

package leetcode;

/**
 * https://leetcode.com/problems/rotate-image/#/description
 * https://discuss.leetcode.com/topic/6796/a-common-method-to-rotate-the-image
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 */
public class RotateImage {

    /*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/

    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        reverseUpDown(matrix);
        for (int row = 0; row < rows; row++) {
            for (int col = row + 1; col < cols; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }

    private void reverseUpDown(int[][] matrix) {
        int start = 0;
        int end = matrix[0].length - 1;

        while (start < end) {
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;
            end--;
        }
    }

}

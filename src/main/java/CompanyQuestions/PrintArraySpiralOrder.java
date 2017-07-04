package CompanyQuestions;

import java.util.ArrayList;
import java.util.List;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 * Print 2D MXN Integer grid in a clockwise spiral
 * E.g [[1, 2, 3],
 *      [4, 5, 6],
 *      [7, 8, 9]]
 * 1
 * 2
 * 3
 * 6
 * 9
 * 8
 * 7
 * 4
 * 5
 */


public class PrintArraySpiralOrder {

    public static void main(String[] args) {
        PrintArraySpiralOrder soln = new PrintArraySpiralOrder();

        int[][] matrix = new int[2][2];
        matrix[0] = new int[]{1, 2};
        matrix[1] = new int[]{3, 4};

        System.out.println(soln.spiral(matrix));
    }

     List<Integer> spiral(int[][] matrix) {
        List<Integer> output = new ArrayList<>();
        if (matrix.length == 0) {
            return output;
        }
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int top = 0;
        int right = numCols - 1;
        int bottom = numRows - 1;
        int left = 0;

        while (output.size() < numRows * numCols) {
            for (int i = left; i <= right; i++) {
                output.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                output.add(matrix[i][right]);
            }
            right--;

            if (output.size() == numRows * numCols) {
                return output;
            }

            for (int i = right; i >= left; i--) {
                output.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                output.add(matrix[i][left]);
            }
            left++;

        }
        return output;
    }
}
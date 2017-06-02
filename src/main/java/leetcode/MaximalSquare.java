package leetcode;

/*
https://leetcode.com/problems/maximal-square/#/description
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Return 4
 */
public class MaximalSquare {

    public int maximalSquareDP(char[][] a) {
        if (a == null || a.length == 0 || a[0].length == 0)
            return 0;

        int max = 0, n = a.length, m = a[0].length;

        // dp(i, j) represents the length of the square
        // whose lower-right corner is located at (i, j)
        // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        // return the area
        return max * max;
    }

    public int maximalSquare(char[][] matrix) {

        if (matrix.length < 1) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int area = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    area = Math.max(area, getMaxSquare(matrix, row, col));
                }
            }
        }
        return area;
    }

    private int getMaxSquare(char[][] matrix, int row, int col) {
        int currLen = 0;
        int currHeight = 0;
        int area = 0;

        while (true) {
            for (int currRow = row; currRow <= row + currHeight && currRow < matrix.length; currRow++) {
                if (col + currHeight >= matrix[currRow].length || matrix[currRow][col + currHeight] == '0') {
                    return area;
                }

            }

            for (int currCol = col; currCol <= col + currLen && currCol < matrix[row].length; currCol++) {
                if (row+currLen >= matrix.length || matrix[row + currHeight][currCol] == '0') {
                    return area;
                }

            }

            currHeight++;
            currLen++;
            area = currLen * currHeight;
        }
    }

}

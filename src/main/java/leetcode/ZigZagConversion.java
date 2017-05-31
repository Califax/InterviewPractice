package leetcode;

/*
https://leetcode.com/problems/zigzag-conversion/#/description

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        char[][] matrix = new char[numRows][s.length() + 1];

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                matrix[x][y] = ' ';
            }
        }

        boolean goingDown = true;
        int row = 0;
        int col = 0;
        StringBuilder output = new StringBuilder();

        for (char curr : s.toCharArray()) {
            matrix[row][col] = curr;

            if (row == 0) {
                goingDown = true;
            }

            if (row == numRows - 1) {
                goingDown = false;
            }

            if (goingDown) {
                row++;
            } else {
                row--;
                col++;
            }
        }

        for (int rowX = 0; rowX < matrix.length; rowX++) {
            for (int colY = 0; colY < matrix[0].length; colY++) {
                if (matrix[rowX][colY] != ' ') {
                    output.append(matrix[rowX][colY]);
                }
            }
        }
        return output.toString();
    }
}

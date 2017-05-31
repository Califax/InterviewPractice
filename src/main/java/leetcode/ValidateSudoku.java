package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

http://sudoku.com.au/TheRules.aspx

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.


Just trying to explain how to think about % and /. These two operators can be helpful for matrix traversal problems.

For a block traversal, it goes the following way.

0,0, 0,1, 0,2; < --- 3 Horizontal Steps followed by 1 Vertical step to next level.

1,0, 1,1, 1,2; < --- 3 Horizontal Steps followed by 1 Vertical step to next level.

2,0, 2,1, 2,2; < --- 3 Horizontal Steps.

And so on...
if (i = row and j = col)
But, the j iterates from 0 to 9.

But we need to stop after 3 horizontal steps, and go down 1 step vertical.

Use % for horizontal traversal. Because % increments by 1 for each j : 0%3 = 0 , 1%3 = 1, 2%3 = 2, and resets back.
 So this covers horizontal traversal for each block by 3 steps.

Use / for vertical traversal. Because / increments by 1 after every 3 j: 0/3 = 0; 1/3 = 0; 2/3 =0; 3/3 = 1.

So far, for a given block, you can traverse the whole block using just j.

But because j is just 0 to 9, it will stay only first block. But to increment block, use i. To move horizontally to next block,
 use % again : ColIndex = 3 * i%3 (Multiply by 3 so that the next block is after 3 columns. Ie 0,0 is start of first block, second block is 0,3 (not 0,1);

Similarly, to move to next block vertically, use / and multiply by 3 as explained above. Hope this helps.
 */
public class ValidateSudoku {


    public boolean isValidSudoku(char[][] board) {

        for (int row = 0; row < 9; row++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> currBlock = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.' && !rowSet.add(board[row][col])) {
                    return false;
                }

                if (board[col][row] != '.' && !colSet.add(board[col][row])) {
                    return false;
                }

                int currRow = 3 * (row / 3);
                int currCol = 3 * (row % 3);

                if (board[currRow + col / 3][currCol + col % 3] != '.'
                        && !currBlock.add(board[currRow + col / 3][currCol + col % 3])) {
                    return false;
                }
            }
        }
        return true;

    }

//    public boolean isValidSudoku(char[][] board) {
//        Set<Integer> currCol = new HashSet<>();
//        Set<Integer> currRow = new HashSet<>();
//
//        int rows = board.length;
//        int cols = board[0].length;
//
//        boolean entireSquare = validateSquare(rows, cols, 0, 0, board);
//
//        if (!entireSquare) {
//            return false;
//        }
//
//        for (int row = 0; row < 9; row+=3) {
//            for (int col = 0; col < 9; col+=3) {
//                if (!validateSquare(3, 3, row, col, board)) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
//
//    boolean validateSquare(int rows, int cols, int startRow, int startCol, char[][] board) {
//        Set<Integer> currCol = new HashSet<>();
//        Set<Integer> currRow = new HashSet<>();
//
//        for (int row = startRow; row < rows; row++) {
//            for (int col = startCol; col < cols; col++) {
//                if (board[row][col] != '.' && currRow.contains(Integer.valueOf(board[row][col]))) {
//                    currRow.add(Integer.valueOf(board[row][col]));
//                } else {
//                    return false;
//                }
//            }
//            currRow = new HashSet<>();
//        }
//
//        for (int col = startCol; col < cols; col++) {
//            for (int row = startRow; row < rows; row++) {
//                if (board[row][col] != '.' && currRow.contains(Integer.valueOf(board[row][col]))) {
//                    currRow.add(Integer.valueOf(board[row][col]));
//                } else {
//                    return false;
//                }
//            }
//            currRow = new HashSet<>();
//        }
//        return true;
//    }
}

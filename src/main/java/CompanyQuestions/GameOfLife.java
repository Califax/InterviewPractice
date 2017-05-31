package CompanyQuestions;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*
x o o
o x o
o o o

x = dead
o = alive
*/

/*
Write a function that computes the result of one iteration of Conway's Game of Life. This function should take a board state as input and return the next board state.
The Game of Life is a 2-dimensional cellular automaton. The board state is represented by a 2-d grid of cells, each of which is either alive or dead. Each interior cell has 8 neighbors, the cells that are 1 square away horizontally, vertically, or diagonally. Each edge cell has 5 neighbors, and each corner cell has 3 neighbors. The following rules determine the next state of a cell:

- If the cell is alive: if it has 2 or 3 alive neighbors, it stays alive. Otherwise, it dies.
- If the cell is dead: if it has exactly 3 alive neighbors, it becomes alive. Otherwise, it stays dead.
- The state of each cell is determined only by the state of its neighbors in the last iteration.
*/
public class GameOfLife {

    int[][] board;

    public GameOfLife(int rows, int cols) {
        board = new int[rows][cols];
    }

    int[][] iterateGame() {
        int[][] newBoard = new int[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                int numAlive = countAliveNeighbors(row, col, board.length, board[0].length, board);
                if (board[row][col] == 1) {
                    if (numAlive == 2 || numAlive == 3) {
                        newBoard[row][col] = 1;
                    } else {
                        newBoard[row][col] = 0;
                    }
                } else {
                    if (numAlive == 3) {
                        newBoard[row][col] = 1;
                    }
                }
            }
        }
        return newBoard;
    }

    private int countAliveNeighbors(int x, int y, int nRow, int nCol, int[][] board) {
        int count = 0;
        for (int row = Math.max(x - 1, 0); row < Math.min(nRow - 1, x + 1); row++) {
            for (int col = Math.max(y - 1, 0); col < Math.min(nCol - 1, y + 1); col++) {
                if ((row != x) || (col != y)) {
                    if (board[row][col] == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife(3, 3);
        gameOfLife.board[0][0] = 1;
        gameOfLife.board[1][1] = 1;
        int[][] newBoard = gameOfLife.iterateGame();

        for (int row = 0; row < newBoard.length; row++) {
            for (int col = 0; col < newBoard.length; col++) {
                System.out.print(newBoard[row][col] + " ");
            }
            System.out.println();
        }
    }
}
//
//    static int[][] iterateGame(int[][] board) {
//        int[][] newBoard = new int[board.length][board[0].length];
//
//        for (int row = 0; row < board.length; row++) {
//            for (int col = 0; col < board[0].length; col++) {
//                boolean isAlive = board[row][col] == 1;
//                int numAlive = checkNeighborsAlive(board, row, col);
//                if (isAlive) {
//                    if (numAlive == 2 || numAlive == 3) {
//                        newBoard[row][col] = 1;
//                    } else {
//                        newBoard[row][col] = 0;
//                    }
//                } else {
//                    if (numAlive == 3) {
//                        newBoard[row][col] = 1;
//                    }
//                }
//            }
//        }
//        return newBoard;
//    }
//
//
//
//    int checkNeighborsAlive(int[][] board, row, col) {
//        int numAlive = 0;
//        for (int x = Math.max(row-1, 0); x <= Math.min(row +1, board.length-1); x++) {
//            for (int y = Math.max(col -1, 0); y <= Math.min(col+1, board[0].length-1); y++) {
//                if (x == row && y == col) {
//                    continue;
//                }
//                numAlive += board[x][y] & 1;
//            }
//        }
//        return numAlive;
//    }
//
//    static Point iterateGame(Point startingPoint) {
//        Set<Point> visited = new HashSet<>();
//        Point curr = startingPoint;
//        while (curr != null) {
//            curr = curr.next;
//            int numAlive = getNumNeighborsAlive(curr);
//            if (curr.isAlive) {
//
//            }
//        }
//
//    }
//
//    static class Point {
//        boolean isAlive;
//        List<Point> neighbors;
//        Point next;
//
//        public Point() {
//
//        }
//    }


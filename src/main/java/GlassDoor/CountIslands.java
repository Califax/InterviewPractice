package GlassDoor;

public class CountIslands {
    IslandNode[][] board = new IslandNode[3][3];
    private int rows = board.length;
    private int cols = board[0].length;

    int islands = 0;

    int addLand(int row, int col) {
        IslandNode curr = board[col][row];
        if (curr != null) {
            return islands;
        } else {
            curr = new IslandNode();
            board[row][col] = curr;
            boolean addIsland = true;

            for (int currRow = Math.max(0,row-1); currRow <= Math.min(row+1, rows-1); currRow++) {
                if (currRow == row) {
                    continue;
                }
                if (board[currRow][col] != null) {
                    if (board[currRow][col].isIsland) {
                        board[currRow][col].isIsland = false;
                        islands--;
                    }
                    addIsland = false;
                }
            }

            for (int currCol = Math.max(0, col-1); currCol <= Math.min(col+1, cols-1); currCol++) {
                if (currCol == col) {
                    continue;
                }
                if (board[row][currCol] != null) {
                    if (board[row][currCol].isIsland) {
                        board[row][currCol].isIsland = false;
                        islands--;
                    }
                    addIsland = false;
                }
            }

            if (addIsland) {
                islands++;
                curr.isIsland = true;
            }

        }
        return islands;
    }

    void printBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print("row = " + row + " col = " + col + board[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static class IslandNode {
        boolean isIsland = true;

        @Override
        public String toString() {
            return "is island: " + isIsland;
        }
    }

    public static void main(String[] args) {
        CountIslands obj = new CountIslands();

        System.out.println(obj.addLand(0, 0));
        System.out.println(obj.addLand(2, 0));
        System.out.println(obj.addLand(1, 1));
        System.out.println(obj.addLand(0, 1));
        System.out.println(obj.addLand(0, 1));


    }
}

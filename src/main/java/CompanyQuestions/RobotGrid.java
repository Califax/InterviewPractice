package CompanyQuestions;

public class RobotGrid {

    /*
    For 3x3 grid solution = 6 paths
     */
    static int numPaths(int row, int col, int[][] cache, Node goal) {

//        for (int[] aMemo : cache) {
//            for (int anAMemo : aMemo) {
//                System.out.print(anAMemo + ", ");
//            }
//            System.out.println();
//        }

        if (row == goal.row && col == goal.col) {
            return 1;
        }

        if (row > goal.row || col > goal.col) {
            return 0;
        }

        if (cache[row][col] > 0) {
            return cache[row][col];
        }

        cache[row][col] =  numPaths(row, col + 1, cache, goal) + numPaths(row + 1, col, cache, goal);
        return cache[row][col];
    }

    static class Node {

        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        final int numWays = numPaths(0, 0, new int[3][3], new Node(2, 2));
        System.out.println("numPaths = " + numWays);
    }


}

package GlassDoor;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumMovesKnight {
    int numMovesKnight(Node start, Node end, int[][] grid) {

        Queue<Node> queue = new LinkedList<>();

        int[] rowDelta = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] colDelta = {1, -1, 1, -1, 2, -2, 2, -2};
        queue.add(start);
        Set<Node> visited = new HashSet<>();

        if (start.row == end.row && start.col == end.col) {
            return 0;
        }

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (int i = 0; i < rowDelta.length; i++) {
                Node moved = curr.moveKnight(curr, rowDelta[i], colDelta[i], grid);
                if (moved != null) {
                    if (!visited.contains(moved)) {
                        int numMoves = checkIfEndReturnNumMoves(end, curr);
                        if (numMoves != -1) {
                            return numMoves;
                        }
                        queue.add(moved);
                        visited.add(moved);
                    }
                }
            }
        }
        return -1;
    }

    int checkIfEndReturnNumMoves(Node end, Node curr) {
        int numMoves = 0;
        if (curr.row == end.row && curr.col == end.col) {
            Node tail = curr;

            while (tail.prev != null) {
                numMoves++;
                tail = tail.prev;
            }
            return numMoves;
        }
        return -1;
    }


    private static class Node {
        int row;
        int col;
        Node prev;

        private Node moveKnight(Node curr, int rowDelta, int colDelta, int[][] grid) {
            int newRow = curr.row + rowDelta;
            int newCol = curr.col + colDelta;

            if (newRow < grid.length && newRow >= 0 && newCol >= 0 && newCol < grid[0].length) {
                Node movedNode = new Node();
                movedNode.row = newRow;
                movedNode.col = newCol;
                movedNode.prev = curr;
                return movedNode;
            } else {
                return null;
            }
        }
    }
}

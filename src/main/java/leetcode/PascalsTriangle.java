package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>(new ArrayList<>());
        if (numRows == 0) {
            return output;
        }

        int currRow = 0;

        while (currRow < numRows) {
            List<Integer> currOut = new ArrayList<>(currRow+1);

            int currIndex = 0;
            while (currIndex < currRow+1) {
                if (currIndex == 0 || currIndex == currRow) {
                    currOut.add(1);
                } else {
                    List<Integer> prevRow = output.get(currRow-1);
                    currOut.add(prevRow.get(currIndex-1) + prevRow.get(currIndex));
                }
                currIndex++;
            }
            currRow++;
            output.add(currOut);
        }
        return output;
    }

    public static void main(String[] args) {
        PascalsTriangle obj = new PascalsTriangle();
        obj.generate(4);
    }
}

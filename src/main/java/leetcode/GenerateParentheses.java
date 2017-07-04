package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        genParen(n * 2, output, new StringBuilder(), 0, 0);
        return output;
    }

    private void genParen(int n, List<String> output, StringBuilder currString, int numLeft, int numRight) {
        int length = currString.length();
        if (length == n) {
            output.add(currString.toString());
            currString.setLength(length);
        } else {
            if (numLeft < n / 2) {
                currString.append('(');
                genParen(n, output, currString, numLeft + 1, numRight);
                currString.setLength(length);
            }
            if (numRight < numLeft) {
                currString.append(')');
                genParen(n, output, currString, numLeft, numRight + 1);
                currString.setLength(length);
            }
        }
    }
}

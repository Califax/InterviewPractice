package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/#/description
 * <p>
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * <p>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p>
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 */
public class RemoveInvalidParenthesis {

    public List<String> removeInvalidParentheses(String s) {
        Set<String> output = new HashSet<>();
        int numLeft = 0;
        int numRight = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                numLeft++;
            } else if (curr == ')') {
                if (numLeft != 0) {
                    numLeft--;
                } else {
                    numRight++;
                }
            }
        }
        removeInvalid(s, output, numLeft, numRight, 0, 0, new StringBuilder());
        return new ArrayList<>(output);
    }

    private void removeInvalid(String input, Set<String> output, int numLeftMax, int numRightMax, int numLeft,
                               int index, StringBuilder currOutput) {
        if (numLeftMax < 0 || numRightMax < 0 || numLeft < 0) {
            return;
        }
        int len = currOutput.length();
        if (input.length() == index) {
            if (numLeft == 0) {
                output.add(currOutput.toString());
            }
        } else {
            char curr = input.charAt(index);
            index++;
            if (curr == '(') {
                removeInvalid(input, output, numLeftMax - 1, numRightMax, numLeft, index, currOutput); // don't include '('
                currOutput.append(curr);
                removeInvalid(input, output, numLeftMax, numRightMax, numLeft + 1, index, currOutput);
            } else if (curr == ')') {
                removeInvalid(input, output, numLeftMax, numRightMax - 1, numLeft, index, currOutput); // don't include ')'
                currOutput.append(curr);
                removeInvalid(input, output, numLeftMax, numRightMax, numLeft - 1, index, currOutput);
            } else {
                currOutput.append(curr);
                removeInvalid(input, output, numLeftMax, numRightMax, numLeft, index, currOutput);
            }
        }
        currOutput.setLength(len);
    }

}

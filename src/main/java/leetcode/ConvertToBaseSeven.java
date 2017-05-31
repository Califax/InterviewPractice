package leetcode;

/*
https://leetcode.com/problems/base-7/#/description

Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].
 */
public class ConvertToBaseSeven {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder curr = new StringBuilder();
        int mod = 0;
        boolean isNegative = num < 0;
        while (num != 0) {
            mod = num % 7;
            num /= 7;
            curr.append(String.valueOf(Math.abs(mod)));
        }
        if (isNegative) {
            curr.append('-');
        }
        return curr.reverse().toString();
    }
}

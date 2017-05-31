package leetcode;
// https://leetcode.com/problems/longest-palindromic-substring/#/description
//        Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//        Example:
//
//        Input: "babad"
//
//        Output: "bab"
//
//        Note: "aba" is also a valid answer.
//        Example:
//
//        Input: "cbbd"
//
//        Output: "bb"

public class LongestPalindromicString {

    public String longestPalindrome(String s) {
        return null;
    }

    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

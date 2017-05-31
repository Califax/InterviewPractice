package leetcode;

import java.util.InputMismatchException;

public class ReverseAnInteger {

    static private int reverseInt(int val) {

        boolean isNegative = false; // can remove flag for java

        if (val < 0) {
            val = 0 - val;
            isNegative = true;
        }

        int result = 0;
        int mod = 0;

        while (val != 0) {
            mod = val % 10;
            val = val / 10;
            if (result != 0 && Integer.MAX_VALUE / result < 10 // catch Integer Overrflow
                    && Integer.MAX_VALUE / result > -10) {
                throw new InputMismatchException("reversing does not result in a valid integer");
            }
            result = result * 10 + mod;
        }

        if (isNegative) {
            result = 0 - result;
        }
        return result;
    }

    // if using to check palindromes O(1) space
    static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return x - reverseInt(x) == 0;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
//    1000000003
        final boolean palindrome = isPalindrome(2112);
        System.out.println("palindrome = " + palindrome);
    }
}


package CrackingTheCodingInterview;

/*
page 346
A magic index in an array A[1...n-1] is defined to be an index such that A[i] = i.
Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A
 */

public class MagicIndex {

    int findMagicIndex(int[] nums) {
        return findMagicIndex(nums, 0, nums.length - 1);
    }

    private int findMagicIndex(int[] nums, int start, int end) {
        int mid = start + ((end - start) / 2);

        if (start > end) {
            return -1;
        }

        if (nums[mid] == mid) {
            return mid;
        } else if (nums[mid] < mid) {
            return findMagicIndex(nums, mid+1, end);
        } else {
            return findMagicIndex(nums, start, mid-1);
        }
    }

    private int findMagicIndexNonDistinct(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + ((end - start) / 2);

        int midVal = nums[mid];

        if (nums[mid] == mid) {
            return mid;
        }

        int checkLeft = findMagicIndexNonDistinct(nums, start, Math.min(mid-1, midVal));
        if (checkLeft != -1) {
            return checkLeft;
        }
        int checkRight = findMagicIndexNonDistinct(nums, Math.max(mid+1, midVal), end);
        return checkRight;
    }



    // What if these elements are not distinct?


}

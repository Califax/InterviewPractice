package leetcode;

/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {

        int foundAt = binarySearch(nums, target, 0, nums.length);

        int leftRange = foundAt;
        int rightRange = foundAt;

        int[] ans = new int[2];

        while (leftRange - 1 > 0 && nums[leftRange - 1] == target) {
            leftRange--;
        }

        while (rightRange + 1 < nums.length - 1 && nums[rightRange + 1] == target) {
            rightRange++;
        }

        ans[0] = leftRange;
        ans[1] = rightRange;

        return ans;
    }

    private int binarySearch(int[] nums, int target, int low, int high) {
        int mid = low + ((high-low) / 2);

        if (nums[mid] == target) {
            return mid;
        } else if (low >= high) {
            return -1;
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, low, mid-1);
        } else {
            return binarySearch(nums, target, mid+1, high);
        }
    }

}

package GlassDoor;

/**
 * http://www.geeksforgeeks.org/find-local-minima-array/
 *
 * Find a local minima in an array
 * Given an array arr[0 .. n-1] of distinct integers, the task is to find a local minima in it. We say that an element
 * arr[x] is a local minimum if it is less than or equal to both its neighbors.
 * <p>
 * For corner elements, we need to consider only one neighbor for comparison.
 * There can be more than one local minima in an array, we need to find any one of them.
 * Examples:
 * <p>
 * Input: arr[] = {9, 6, 3, 14, 5, 7, 4};
 * Output: Index of local minima is 2
 * The output prints index of 3 because it is
 * smaller than both of its neighbors.
 * Note that indexes of elements 5 and 4 are
 * also valid outputs.
 * <p>
 * Input: arr[] = {23, 8, 15, 2, 3};
 * Output: Index of local minima is 1
 * <p>
 * Input: arr[] = {1, 2, 3};
 * Output: Index of local minima is 0
 * <p>
 * Input: arr[] = {3, 2, 1};
 * Output: Index of local minima is 2
 */

public class LocalMinimaInArray {

    int findLocalMinima(int[] nums) {
        return findLocalMinima(nums, 0, nums.length - 1);
    }

    int findLocalMinima(int[] nums, int start, int end) {
        int mid = start + ((end - start) / 2);
        int currVal = nums[mid];

        if ((mid == 0 || currVal < (nums[mid-1])) && (mid == nums.length - 1 || currVal < nums[mid + 1])) {
            return mid;
        }

        if (mid - 1 >= 0 && nums[mid - 1] < nums[mid]) { // If mid > left element there must be local minima to left of mid
            return findLocalMinima(nums, start, mid-1);
        } else {
            return findLocalMinima(nums, mid+1, end); // Same is true for right element
        }
    }

    public static void main(String[] args) {
        LocalMinimaInArray obj = new LocalMinimaInArray();

        System.out.println(obj.findLocalMinima(new int[]{3, 2, 1}));
    }
}

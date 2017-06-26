package GlassDoor;

/**
 * http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 * Maximum sum such that no two elements are adjacent
 Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the
 sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7
 should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.
 */
public class MaxSumNonAdjacentElements {

    static int maxSumNonAdjc(int[] nums) {
        int include = nums[0];
        int exclude = 0;
        int maxExclude = 0;
        for (int i = 1; i < nums.length; i++) {
            maxExclude = Math.max(include, exclude); // excl = max sum excluding the previous element
            include = nums[i] + exclude; // incl = max sum including the previous element
            System.out.println("nums[i] = " + nums[i]);
            System.out.println("exclude = " + exclude);
            System.out.println("include = " + include);
            System.out.println("maxExclude = " + maxExclude);
            exclude = maxExclude;
        }
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
//        System.out.println("expected 15 got: " + maxSumNonAdjc(new int[]{3, 2, 5, 10, 7}));
        System.out.println("expected 13 got: " + maxSumNonAdjc(new int[]{1, 4, 2, 7, 9}));
    }
}

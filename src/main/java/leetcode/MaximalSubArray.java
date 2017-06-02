package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaximalSubArray {

    public static void main(String[] args) {
        MaximalSubArray obj = new MaximalSubArray();
        int[] nums = {-3, 4, -1, 3};
        int[] nums2 = {-3, -2, 0, -4};
        int[] nums3 = {-3, -2, 0, 2};
        int[] nums4 = {-1, 4, -3, -2};
        List<Integer> integers = obj.maxSubArrayList(Arrays.stream(nums4).boxed().collect(Collectors.toList()));
        System.out.println("integers = " + integers);
    }

    public List<Integer> maxSubArrayList(List<Integer> nums) {
        if (nums.isEmpty() || nums.size() == 1) {
            return nums;
        }
        int maxEndingHere = nums.get(0);
        int maxSoFar = nums.get(0);
        int endIndex = 0;
        int startIndex = 0;
        int currStartIndex = 0;

        for (int i = 1; i < nums.size(); i++) {
            Integer curr = nums.get(i);

            if (maxEndingHere + curr > curr) {
                maxEndingHere = maxEndingHere + curr;
            } else {
                maxEndingHere = curr;
                currStartIndex = i;
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                startIndex = currStartIndex;
                endIndex = i;
            }
        }

        System.out.println("startIndex = " + startIndex);
        System.out.println("endIndex = " + endIndex);
        System.out.println("sum: " + maxSoFar);

        return nums.subList(startIndex, endIndex+1);
    }

    /*
    Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

    For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
    the contiguous subarray [4,-1,2,1] has the largest sum = 6.
     */
    int maxSubArray(int[] nums) {
        int maxEndingHere = 0;
        int maxSoFar = 0;

        if (nums.length == 1) {
            return nums[0];
        }

        for (int i = 0; i < nums.length; i++) {
            maxEndingHere = Math.max(0, maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

}

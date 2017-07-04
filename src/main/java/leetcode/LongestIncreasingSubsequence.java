package leetcode;

import java.util.Arrays;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one
LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int maxLength = Math.min(1, nums.length);
        int[] bestHere = new int[nums.length+1];
        Arrays.fill(bestHere, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (bestHere[i] < bestHere[j] + 1 && nums[j] < nums[i]) {
                    bestHere[i] = bestHere[j] + 1;
                }
                if (maxLength < bestHere[i]) {
                    maxLength = bestHere[i];
                }
            }
        }
        return maxLength;
    }

}
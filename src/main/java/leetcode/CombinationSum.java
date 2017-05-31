package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]
https://leetcode.com/problems/combination-sum/
*/
public class CombinationSum {

    public List<List<Integer>> combinationSumWithBackTrack(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>(new ArrayList<>());
        combinationSumWithBackTrack(candidates, target, new ArrayList<>(), 0, output);
        return output;
    }

    // If we don't want to make copy in each part of for loop, this is faster
    private void combinationSumWithBackTrack(int[] candidates, int target, List<Integer> currValues, int currSum, List<List<Integer>> output) {
        if (target == currSum) {
            output.add(new ArrayList<>(currValues));
        } else {
            for (int i = 0; i < candidates.length; i++) {
                int currValue = candidates[i];
                if (currSum + currValue <= target && (currValues.isEmpty() || currValue >= currValues.get(currValues.size()-1))) { // make sure will not go 2 2 3 then 2 3 2
                    currValues.add(currValue);
                    combinationSumWithBackTrack(candidates, target, currValues, currSum+currValue, output);
                    currValues.remove(currValues.size()-1);
                }
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>(new ArrayList<>());
        combinationSum(candidates, target, new ArrayList<>(), 0, output);
        return output;
    }

    private void combinationSum(int[] candidates, int target, List<Integer> currValues, int currSum, List<List<Integer>> output) {
        if (target == currSum) {
            output.add(currValues);
        } else {
            for (int i = 0; i < candidates.length; i++) {
                List<Integer> copy = new ArrayList<>(currValues);
                int currValue = candidates[i];
                // Checking previous for uniqueness
                if (currSum + currValue <= target && (currValues.isEmpty() || currValue >= currValues.get(currValues.size()-1))) {
                    copy.add(currValue);
                    combinationSum(candidates, target, copy, currSum+currValue, output);
                }
            }
        }
    }

    public List<List<Integer>> combinationSumBackTrackSortedWithStartIndex(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

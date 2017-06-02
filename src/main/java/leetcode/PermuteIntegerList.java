package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermuteIntegerList {
//
//    static List<List<Integer>> permuteSwap(List<Integer> nums) {
//     return permuteSwap(nums, 0, new ArrayList<>(new ArrayList<>()));
//    }
//
//    static List<List<Integer>> permuteSwap(List<Integer> nums, int currIndex, List<List<Integer>> output) {
//        if (currIndex == nums.size()) {
//            System.out.println(nums);
//            output.add(new ArrayList<>(nums));
//        } else {
//            for (int i = currIndex; i < nums.size(); i++) {
//                swap(nums, i, currIndex);
//                permuteSwap(nums, currIndex+1, output);
//                swap(nums, i, currIndex);
//            }
//        }
//        return output;
//    }
//
//    private static void swap(List<Integer> nums, Integer first, Integer second) {
//        Integer temp = nums.get(second);
//        nums.set(second, nums.get(first));
//        nums.set(first, temp);
//    }
//
//    static List<List<Integer>> permuteBackTrack(List<Integer> nums) { // only works if no duplicates
//        return permuteBackTrack(nums, new ArrayList<>(), new ArrayList<>(new ArrayList<>()));
//    }
//
//    static List<List<Integer>> permuteBackTrack(List<Integer> nums, List<Integer> currNums, List<List<Integer>> output) {
//        if (nums.size() == currNums.size()) {
//            output.add(new ArrayList<>(currNums));
//            System.out.println(currNums.toString());
//        } else {
//            for (int i = 0; i < nums.size(); i++) {
//                if (currNums.contains(nums.get(i))) { // if no duplicates
//                    continue;
//                }
//                currNums.add(nums.get(i));
//                permuteBackTrack(nums, currNums, output);
//                currNums.remove(currNums.size()-1);
//            }
//        }
//        return output;
//    }
//
////    https://leetcode.com/problems/permutations-ii/#/description
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
//        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
//        return list;
//    }
//
//    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used){
//        if (tempList.size() == nums.length) {
//            list.add(new ArrayList<>(tempList));
//        } else{
//            for (int i = 0; i < nums.length; i++){
//                if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) {
//                    continue;
//                }
//                used[i] = true;
//                tempList.add(nums[i]);
//                backtrack(list, tempList, nums, used);
//                used[i] = false;
//                tempList.remove(tempList.size() - 1);
//            }
//        }
//    }
//
//    public List<List<Integer>> permute(int[] nums) {
//        List<Integer> ints = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        return permute(ints, new ArrayList<>(new ArrayList<>()), new ArrayList<>());
//    }
//
//    private List<List<Integer>> permute(List<Integer> nums, List<List<Integer>> output, List<Integer> currList) {
//        if (nums.isEmpty()) {
//            output.add(currList);
//            System.out.println("currList = " + currList);
//        } else {
//            for (int i = 0; i < nums.size(); i++) {
//                List<Integer> copy = new ArrayList<>(currList);
//                List<Integer> numCopy = new ArrayList<>(nums);
//                copy.add(nums.get(i));
//                List<Integer> copyNums = numCopy.subList(0, i);
//                copyNums.addAll(numCopy.subList(i + 1, nums.size()));
//                permute(copyNums, output, copy);
//            }
//        }
//        return output;
//    }
//
//    public static void main(String[] args) {
//        final PermuteIntegerList obj = new PermuteIntegerList();
//
//        List<Integer> input = Arrays.stream(new int[]{1, 2, 3}).boxed().collect(Collectors.toList());
////        obj.permute(new int[]{1, 2, 3});
//        permuteSwap(input);
////        permuteBackTrack(input);
////        obj.permute(new int[]{1, 2, 3});
////        final List<List<Integer>> permute = obj.permute(new int[]{1, 2, 3});
//
////        final List<Integer> integers = Lists.newArrayList(1, 2).subList(2, 2);
////        System.out.println("integers = " + integers);
////        System.out.println("permute = " + permute);
//    }
}

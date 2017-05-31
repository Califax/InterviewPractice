package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {

        if (nums.length <= 1) {
            return;
        }

        int breaksDescOrder = -1;

        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                breaksDescOrder = i - 1;
                break;
            }
        }

        int j = nums.length - 1;

        if (breaksDescOrder >= 0) {
            while (nums[breaksDescOrder] >= nums[j]) {
                j--;
            }
            swap(nums, breaksDescOrder, j);
        }

        reverseSort(nums, breaksDescOrder+1, nums.length-1);
    }

    private void swap(int[] nums, int one, int two) {
        int temp = nums[one];
        nums[one] = nums[two];
        nums[two] = temp;
    }

    private void reverseSort(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = {4, 2, 3, 1};
        nextPermutation.nextPermutation(nums);
        Arrays.stream(nums).boxed().forEach(System.out::print);
        System.out.println();

        int[] nums2 = {1, 3, 2};
        nextPermutation.nextPermutation(nums2);
        Arrays.stream(nums2).boxed().forEach(System.out::print);
        System.out.println();
    }
}

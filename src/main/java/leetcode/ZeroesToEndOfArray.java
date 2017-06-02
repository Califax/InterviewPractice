package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
Move all 0's in an array of num to the end
Contraints: In place

ex: {4, 0, 5, 3, 0, 0, 1} becomes : {4, 5, 3, 1, 0, 0, 0}
 */
public class ZeroesToEndOfArray {

    void moveZeroes(int[] nums) {
        int lastKnownNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) { // found a non zero, need to move up
                int temp = nums[lastKnownNonZero];
                nums[lastKnownNonZero] = nums[i];
                nums[i] = temp;
                lastKnownNonZero++;
            }
        }
    }

    public static void main(String[] args) {
        ZeroesToEndOfArray obj = new ZeroesToEndOfArray();
        int[] nums = {4, 0, 5, 3, 0, 0, 1};
        obj.moveZeroes(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
}

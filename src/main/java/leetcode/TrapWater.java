package leetcode;

/**
 * https://leetcode.com/articles/trapping-rain-water/
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrapWater {
    public int trap(int[] height) {

        if (height.length <= 2) {
            return 0;
        }

        int area = 0;
        int left = 0;
        int right = 0;

        int currLeftHeight = 0;
        int currRightHeight = 0;

        for (int i = 0; i < height.length; i++) {
            if (currLeftHeight < height[i]) {
                left = i;
                currLeftHeight = height[i];
                break;
            }
        }

        for (int i = height.length - 1; i > left; i--) {
            if (currRightHeight < height[i]) {
                right = i;
                currRightHeight = height[i];
                break;
            }
        }

        while (left < right) {
            if (currLeftHeight < currRightHeight) {
                while (left < right && currLeftHeight >= height[left]) {
                    area += currLeftHeight - height[left];
                    left++;
                }
                currLeftHeight = height[left];
            } else {
                while (left < right && currRightHeight >= height[right]) {
                    area += currRightHeight - height[right];
                    right--;
                }

                currRightHeight = height[right];
            }
        }

        return area;
    }
}

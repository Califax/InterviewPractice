package leetcode;

import java.util.HashSet;
import java.util.Set;


/**
 * https://leetcode.com/problems/line-reflection/#/description
 *
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

 Example 1:
 Given points = [[1,1],[-1,1]], return true.

 Example 2:
 Given points = [[1,1],[-1,-1]], return false.
 */
public class LineReflection {
    public boolean isReflected(int[][] points) {
        Set<Point> pointSet = new HashSet<>();
        int leftMostX = Integer.MAX_VALUE;
        int rightMostX = Integer.MIN_VALUE;

        for (int[] pointArr : points) {
            Point curr = new Point(pointArr[0], pointArr[1]);
            if (curr.x <= leftMostX) {
                leftMostX = curr.x;
            }
            if (curr.x >= rightMostX) {
                rightMostX = curr.x;
            }
            pointSet.add(curr);
        }

        int sum = rightMostX + leftMostX;

        for (Point point : pointSet) {
            int newX = sum - point.x;
            Point target = new Point(newX, point.y);
            if (!pointSet.contains(target)) {
                return false;
            }
        }
        return true;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public boolean equals(Object o) {
            Point other = (Point) o;
            return this.x == other.x && this.y == other.y;
        }
    }
}

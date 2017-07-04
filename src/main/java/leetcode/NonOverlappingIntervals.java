package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * <p>
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 * Example 1:
 * Input: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * Output: 1
 * <p>
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * Example 2:
 * Input: [ [1,2], [1,2], [1,2] ]
 * <p>
 * Output: 2
 * <p>
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * Example 3:
 * Input: [ [1,2], [2,3] ]
 * <p>
 * Output: 0
 * <p>
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 *
 * https://en.wikipedia.org/wiki/Interval_scheduling#Interval_Scheduling_Maximization
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o.end)); // == (Interval o1, Interval o2) -> o1.end - o2.end

        // [ [1,2], [2,3], [3,4], [1,3] ] -> [ [1,2], [1,3], [2,3], [3,4]

        int end = Integer.MIN_VALUE;
        int count = 0;
        // counts number of non-overlapping interval
        for (int i = 0; i < intervals.length; i++) {
            Interval curr = intervals[i];
            if (curr.start >= end) {
                count++;
                end = curr.end;
            }
        }
        return intervals.length - count;
    }

    private boolean overlaps(Interval one, Interval two) {
        return (one.start < two.end && one.end > two.start);
    }
}

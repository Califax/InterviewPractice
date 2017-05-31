package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*

Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made
 to the system in chronological order (ie, the timestamp is monotonically increasing).
 You may assume that the earliest timestamp starts at 1.
 */
public class HitCounter {

    List<Integer> hits;
    List<Integer> times;

    public HitCounter(int secondsToLookBack) {
        hits = new ArrayList<>(secondsToLookBack);
        times = new ArrayList<>(secondsToLookBack);
    }

    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times.get(index) == timestamp) {
            hits.set(index, hits.get(index) + 1);
        } else {
            times.set(index, timestamp);
            hits.set(index, 1);
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        List<Integer> hitCopy = Collections.unmodifiableList(hits);
        List<Integer> timeCopy = Collections.unmodifiableList(times);
        Integer count = 0;
        for (int i = 0; i < timeCopy.size(); i++) {
            if (timeCopy.get(i) > timestamp - 300) {
                count += hitCopy.get(i);
            }
        }
        return count;
    }
}

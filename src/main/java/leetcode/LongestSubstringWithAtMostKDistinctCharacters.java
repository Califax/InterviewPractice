package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/#/description
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.

 For example, Given s = “eceba” and k = 2,

 T is "ece" which its length is 3.
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        String input = s;
        if (k == 0 || s.isEmpty()) {
            return 0;
        }
        int start = 0;
        int maxStart = 0;
        int maxEnd = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (freqMap.containsKey(curr)) {
                freqMap.put(curr, freqMap.get(curr) + 1);
            } else {
                freqMap.put(curr, 1);
                while (freqMap.size() > k) {
                    int count = freqMap.get(input.charAt(start));
                    if (count == 1) {
                        freqMap.remove(input.charAt(start));
                    } else {
                        freqMap.put(input.charAt(start), count - 1);
                    }
                    start++;
                }
            }

            if (i - start >= maxEnd - maxStart) {
                maxStart = start;
                maxEnd = i;
            }
        }
        return input.substring(maxStart, maxEnd + 1).length();
    }
}

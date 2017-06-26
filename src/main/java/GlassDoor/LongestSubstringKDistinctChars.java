package GlassDoor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringKDistinctChars {

    static String longestSubstringKDistinct(String input, int k) {
        if (input.length() < k) {
            return "";
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
        if (freqMap.size() < k) {
            return "";
        } else {
            return input.substring(maxStart, maxEnd + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("expected: bbcc got: " + longestSubstringKDistinct("aabbcc", 2));
        System.out.println("expected: bcbbbbcccb got: " + longestSubstringKDistinct("abcbbbbcccbdddadacb", 2));
    }
}

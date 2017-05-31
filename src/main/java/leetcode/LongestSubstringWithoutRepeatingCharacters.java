package leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {

    /// O(2N) = O(N)
    static int lengthOfLongestSubstring(String s) {
        Set<Character> currSet = new HashSet<>();
        int currStartIndex = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            final char currChar = s.charAt(i);
            while (currStartIndex < i && currSet.contains(currChar)) {
                currSet.remove(s.charAt(currStartIndex));
                currStartIndex++;
            }
            currSet.add(currChar);
            maxLength = Math.max(maxLength, currSet.size());
        }
        return maxLength;
    }
}

//  "q r s v b s p k"
//  d v d f
// t m m z u x t

  /*
    p w w w k e w
   */
  /*
        A B* C A D B F G H^
   */

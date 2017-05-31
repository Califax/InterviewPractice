package leetcode;

/*
  //Longest common prefix of list of strings
  //IN: ['abcd', 'abdc', 'abe']
  //OUT: 'ab'
  //IN: ['abcd', 'abdc', 'badc']
  //OUT: ''
 */

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String longestSoFar = "";

        for (String word: strs) {
            if (word.isEmpty()) {
                return word;
            }
            if (longestSoFar.isEmpty()) {
                longestSoFar = word;
                continue;
            }
            int currIndex = 0;

            while (currIndex < word.length() && currIndex < longestSoFar.length() &&
                    word.charAt(currIndex) == longestSoFar.charAt(currIndex)) {
                currIndex++;
            }

            if (currIndex == 0) {
                return "";
            }

            longestSoFar = longestSoFar.substring(0, currIndex);
        }

        return longestSoFar;
    }
}

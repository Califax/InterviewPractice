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

        String longestSoFar = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String curr = strs[i];
            int index = 0;
            StringBuilder builder = new StringBuilder();
            while (index < Math.min(curr.length(), longestSoFar.length())) {
                if (curr.charAt(index) == longestSoFar.charAt(index)) {
                    builder.append(curr.charAt(index));
                    index++;
                } else {
                    break;
                }
            }
            longestSoFar = builder.toString();
            if (longestSoFar.isEmpty()) {
                return "";
            }
        }
        return longestSoFar;
    }

    public String longestCommonPrefix2(String[] strs) {

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

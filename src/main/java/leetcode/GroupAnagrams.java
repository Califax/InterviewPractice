package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/#/description
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note: All inputs will be in lower-case.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> output = new ArrayList<>(new ArrayList<>());

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);
            List<String> anagrams = map.get(sorted);
            if (anagrams == null) {
                anagrams = new ArrayList<>();
                anagrams.add(str);
                map.put(sorted, anagrams);
            } else {
                anagrams.add(str);
            }
        }

        for (Map.Entry<String, List<String>> entries : map.entrySet()) {
            output.add(entries.getValue());
        }

        return output;
    }

    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        obj.groupAnagrams(input);
    }
}

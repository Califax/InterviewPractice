package CompanyQuestions;

// """
//  // Given a string s and a list of words w, determine if s can be split into a space-separated sequence of one or more words in w.
//
//  // For example, given
//  // s = "catdog"
//  // w = ["dog", "car", "catch", "tiger", "at", "catdog"]
//  // ==> False
//
//  // s = "catdogtail"
//  // w = ["dog", "car", "catch", "cat", "tiger", "at"]
//  // ==> False
//
//  // s = "catdogtail"
//  // w = ["dog", "car", "catch", "tail", "cat", "tiger", "at"]
//  // ==> True
//
//  // s = "atdogtail"
//  // w = ["atdog", "tail", "cat", "tail", "cat", "tiger", "at"]
//  // ==> True
//
//  // Return true because "catdog" can be segmented as "cat", "dog", and both of them are in dict.
//
//  // """

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CanFormWordInDictionaryByBreaking {

    static boolean canFormWordByBreaking(String word, Set<String> wordList) {
        if (word.isEmpty() || wordList.contains(word)) {
            return false;
        }

        return canBreak(word, wordList);
    }

    private static boolean canBreak(String word, Set<String> wordList) {

        if (word.isEmpty()) {
            return true;
        }

        for (int i = 0; i < word.length(); i++) {
            boolean found = wordList.contains(word.substring(0, i+1)) && canBreak(word.substring(i+1), wordList);
            if (found) {
                return true;
            }
        }

        return false;
    }

    // I believe this is wrong, the dynamic programming solution is iterative
    // http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
    private static boolean canBreakMemo(String word, Set<String> wordList, Set<String> cache) {
        if (word.isEmpty() || cache.contains(word)) {
            return true;
        }

        for (int i = 0; i < word.length(); i++) {
            boolean found = wordList.contains(word.substring(0, i+1)) &&
                    canBreakMemo(word.substring(i+1), wordList, cache);
            if (found) {
                cache.add(word);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Set<String> dict = Arrays.stream(new String[] {"atdog", "tail", "cat", "tail", "cat", "tiger", "at"})
                .collect(Collectors.toSet());

        String input = "atdogtail";
        System.out.println("expectedTrue: " + canFormWordByBreaking(input, dict));
        dict.remove("atdog");
        dict.add("dog");

        System.out.println("expectedTrue: " + canFormWordByBreaking(input, dict));

        Set<String> emptyDict = new HashSet<>();

        System.out.println("expectedFalse " + canFormWordByBreaking(input, emptyDict));
        System.out.println("expectedFalse: " + canFormWordByBreaking("", emptyDict));

        String[] inputArr = {"dog", "car", "catch", "tiger", "at", "catdog"};
        Set<String> dictionary = Arrays.stream(inputArr).collect(Collectors.toSet());
        System.out.println("expectedFalse: " + canFormWordByBreaking("catdog", dictionary));


        Set<String> dict2 = Arrays.stream(new String[] {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa"})
                .collect(Collectors.toSet());

        Set<String> dict3 = new HashSet<>();
        Collections.addAll(dict3, new String[] {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa"});
        System.out.println("expectedFalse: " + canFormWordByBreaking("aaaaaaab", dict3));

    }

}

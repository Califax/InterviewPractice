package GlassDoor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
Given two words and a dictionary, print the path from one word to the next changing one letter at a time

input: cat target: con

dict: {"hat", "cot", "pat", "con"}

solution: cat -> cot -> con

input: cats target: pans

dict: {"patz", "hats" , "patz", "hans", "pans"}

solution: cats -> hats -> hans -> pans
 */
public class PathToDictionaryWord {

    // run a BFS from input to target
    static List<String> getPath(String input, String target, Set<String> dict) {
        LinkedList<WordNode> queue = new LinkedList<>();
        List<String> inputPath = new ArrayList<>();
        inputPath.add(input);
        queue.add(new WordNode(input, inputPath));

        while (!queue.isEmpty()) {
            WordNode currWordNode = queue.remove();
            String currWord = currWordNode.word;
            List<String> currPath = currWordNode.path;

            if (currWord.equals(target)) {
                return currPath;
            }

            for (int i = 0; i < input.length(); i++) {
                for (char currChar = 'a'; currChar <= 'z'; currChar++) {
                    String newWord = currWord.substring(0, i) + currChar + currWord.substring(i + 1, input.length());
                    if (dict.contains(newWord)) {
                        List<String> copy = new ArrayList<>(currPath); // Could store prevNode in WordNode to avoid copying lists then build once we find an answer.
                        copy.add(newWord);
                        queue.add(new WordNode(newWord, copy));
                        dict.remove(newWord);
                    }
                }
            }
        }

        return inputPath;
    }

    private static class WordNode {
        String word;
        List<String> path;
        // Could store prevNode here to avoid copying lists then build once we find an answer.

        WordNode(String word, List<String> path) {
            this.word = word;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        Set<String> dict = Arrays.stream(new String[]{"hat", "cot", "pat", "con"}).collect(Collectors.toSet());
        String expected = "[cat, cot, con]";
        System.out.println("expected: " + expected + " got: " + getPath("cat", "con", dict));
        expected = "[cats, hats, hans, pans]";
        dict = Arrays.stream(new String[]{"patz", "hats", "patz", "hans", "pans"}).collect(Collectors.toSet());
        System.out.println("expected: " + expected + " got: " + getPath("cats", "pans", dict));
    }
}
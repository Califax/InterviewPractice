package GlassDoor;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubstrings {

//    n(n+1) / 2 =  (n^2 + n) / 2 substrings

    static List<String> getSubstrings(String input) {
        List<String> output = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            for (int j = i +1; j <= input.length(); j++) {
                output.add(input.substring(i, j));
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(getSubstrings("abab"));
    }
}

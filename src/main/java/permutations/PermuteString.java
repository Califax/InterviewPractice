package permutations;

import java.util.ArrayList;
import java.util.List;

public class PermuteString {

    List<String> genPerms(String input) {
       return genPerms(input, "", new ArrayList<>());
    }

    List<String> genPerms(String input, String prefix, List<String> output) {

        if (input.isEmpty()) {
            output.add(prefix);
        } else {
            for (int i = 0; i < input.length(); i++) {
                System.out.println("input = " + input);
                System.out.println("prefix = " + prefix);
                genPerms(input.substring(0, i) + input.substring(i+1), prefix + input.charAt(i), output);
            }
        }
        return output;
    }



    public static void main(String[] args) {
        PermuteString obj = new PermuteString();
        List<String> perms = obj.genPerms("abc");
        System.out.println("perms = " + perms);
    }
}

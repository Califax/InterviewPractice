package permutations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhonePermutations {

    Map<String, String> genNumMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("2", "abc");
        hashMap.put("3", "def");
        hashMap.put("4", "ghi");
        hashMap .put("5", "jkl");
        hashMap.put("6", "mno");
        hashMap.put("7", "pqrs");
        hashMap.put("8", "tuv");
        hashMap.put("9", "wxyz");
        return hashMap;
    }

    List<String> phonePerms(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        return phonePerms(digits, "", genNumMap(), new ArrayList(), 0);
    }

    List<String> phonePerms(String input, String prefix, Map<String, String> numMap, List<String> output, int currIndex) {
        if (prefix.length() == input.length()) {
            output.add(prefix);
            return output;
        } else {
            final String digitMapping = numMap.get(String.valueOf(input.charAt(currIndex)));
            for (int i = 0; i < digitMapping.length(); i++) {
                phonePerms(input, prefix + digitMapping.charAt(i), numMap, output, currIndex+1);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        final PhonePermutations phonePermutations = new PhonePermutations();
        System.out.println(phonePermutations.phonePerms("23"));
    }

}

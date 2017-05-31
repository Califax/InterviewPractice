package permutations;

/**
 * Given a String containing integers [0-9] print all possible code combinations
 * e.g. 123 :
 * 111, 112, 113, 121, etc.
 */
public class CodeString {

    static void printCode(String input, String currCode) {

        if (currCode.length() == input.length()) {
            System.out.println(currCode);
        } else {
            for (int i = 0; i < input.length(); i++) {
                printCode(input, currCode + input.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        printCode("123", "");
    }
}

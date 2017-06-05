package permutations;

public class Perm {

    void printWords(String input) {
        permute(input, "");
    }

    private void permute(String input, String prefix) {
        if (isWord(prefix)) {
            System.out.println(prefix);
        }
        if (prefix.isEmpty() || isPrefix(prefix)) {
            for (int i = 0; i < input.length(); i++) {
                permute(input.substring(0, i) + input.substring(i+1) ,prefix + input.charAt(i));
            }
        }
    }

    boolean isWord(String s) {
        return true;
    }

    boolean isPrefix(String s) {
        return true;
    }

    public static void main(String[] args) {
        Perm obj = new Perm();
        obj.permute("abc", "");
    }
}

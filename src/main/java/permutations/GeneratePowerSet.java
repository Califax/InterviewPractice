package permutations;

import java.util.ArrayList;
import java.util.List;

public class GeneratePowerSet {

    static List<String> genPowerSet(String input) {

        int size = 2 << input.length() - 1;
        List<String> output = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            // TODO: make the "%3s" have the 3 be the input.length-1
            String binary = String.format("%3s", Integer.toBinaryString(i)).replace(' ', '0'); // pads to size 3 with 0s at beginning
//      String binary = Integer.toBinaryString(i);
//      while (binary.length() < input.length()) {
//        binary = "0" + binary;
//      }
            StringBuilder currString = new StringBuilder();
            for (int curr = binary.length() - 1; curr >= 0; curr--) {
                if (binary.charAt(curr) - '0' == 1) {
                    currString.append(input.charAt(curr));
                }
            }
            output.add(currString.toString());
        }
        return output;
    }

//  static List<String> genPowerSet(String input) {
//
//    int size = 2 << input.length()-1;
//    List<String> output = new ArrayList<>();
//    for (int i = 0; i < size; i++) {
//      String binary = Integer.toBinaryString(i);
//      StringBuilder currString = new StringBuilder();
//      int binaryDigits = i;
//      System.out.println("binaryDigits = " + binaryDigits);
//      System.out.println(binaryDigits % 2);
//      System.out.println(binaryDigits >>= 1);
//      for (int curr = 0; curr < input.length(); curr++) {
//        if (binaryDigits % 2 == 1) {
//          currString.append(input.charAt(curr));
//        }
//        binaryDigits >>= 1;
//      }
//      output.add(currString.toString());
//    }
//    return output;
//  }

    public static void main(String[] args) {
        List<String> abc = genPowerSet("abc");
        System.out.println("abc = " + abc);
    }
}

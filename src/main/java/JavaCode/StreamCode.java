package JavaCode;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamCode {

    public int[] intsStream(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toList())
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2, o1))
                .mapToInt(x -> x)
                .toArray();
    }

//    static int summation(int[] numbers) {
//
//
//        Integer integer = Arrays.stream(numbers).boxed().collect(Collectors.toList()).stream().reduce((a, b) -> a + b).get();
//    }

    static void minAndMaximalSums(int[] input) {
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;
        Integer sum = new Integer(0);

        Long x = Long.valueOf(sum - max);

        for (Integer val : input) {
            min = Math.min(min, val);
            max = Math.max(max, val);
            sum += val;
        }

        System.out.println(String.format("%s %s", sum - max, sum - min));
    }

    static void test() {
        System.out.println('z' - 'a');
        System.out.println((char)65);
        System.out.println((char) ('0' + 'a'));
//        System.out.println('z' - '0');
    }

    public static void main(String[] args) {
        StreamCode.test();
    }

}

package JavaCode;

import leetcode.ListNode;

import java.util.*;
import java.util.stream.Collectors;

public class StreamCode<K, V> {

    public int[] intsStream(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toList())
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2, o1))
                .mapToInt(x -> x)
                .toArray();
    }

    private static class Generics<K, V> {
        public Map<K, V> map = new HashMap<>();
    }

//    static int summation(int[] numbers) {
//
//
//        Integer integer = Arrays.stream(numbers).boxed().collect(Collectors.toList()).stream().reduce((a, b) -> a + b).get();
//    }

     static void deepCopyMap() {
        Generics<String, ListNode> generics = new Generics<>();
        Map<String, ListNode> mapOne = generics.map;

        ListNode nodeOne = new ListNode(5);
        mapOne.put("a", nodeOne);
        Map<String, ListNode> copy = new HashMap<>();
        for (Map.Entry<String, ListNode> entry : mapOne.entrySet()) {
            copy.put(entry.getKey(), new ListNode(entry.getValue().val));
        }

        System.out.println("copy = " + copy);
        nodeOne.setVal(8);
        System.out.println("mapOne = " + mapOne);
        System.out.println("copy = " + copy);
    }

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
//        System.out.println('z' - 'a');
//        System.out.println((char)65);
//        System.out.println((char) ('0' + 'a'));

//        List<String> inputPath = new Stack<>();
//        inputPath.add("c");
//        inputPath.add("b");
//        inputPath.add("a");
//        List<String> newPath = Arrays.asList("c", "b", "a");
//
//        ListIterator<String> listIt = newPath.listIterator();
//        List<String> visited = Arrays.asList("a", "b");
//
//        while (listIt.hasNext()) {
//            String curr = listIt.next();
//            System.out.println("curr = " + curr);
//            if (visited.contains(curr)) {
//                listIt.remove();
//            }
//        }
//
//        System.out.println("newPath = " + newPath);
////        System.out.println('z' - '0');
    }

    public static void main(String[] args) {
        StreamCode.deepCopyMap();
    }

}

package CompanyQuestions;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class WeightedProbability<T> {

    public static void main(String[] args) {
        List<Weight> weights = new ArrayList<>();
        weights.add(new Weight(10.0, "NYC"));
        weights.add(new Weight(0.9, "SF"));
        weights.add(new Weight(6.0, "ATLANTA"));
        WeightedProbability obj = new WeightedProbability(weights);
        obj.getRandomWeight();
    }

    private TreeMap<Double, Weight> weightedMap;
    private final List<Weight> weights;
    private double maxWeight;

    WeightedProbability(List<Weight> weights) {
        this.weights = weights;
        weightedMap = genTree(weights);
    }

    private TreeMap<Double, Weight> genTree(List<Weight> weights) {
        Double currWeight = 0.0;
        weightedMap = new TreeMap<>();
        for (Weight weight : weights) {
            currWeight += weight.weight;
            weightedMap.put(currWeight, weight);
            System.out.println("weightedMap = " + weightedMap);
        }
        maxWeight = currWeight;
        return weightedMap;
    }

    private Weight getRandomWeight() {
        double rand = new Random().nextDouble();
        System.out.println("rand = " + rand);
        double randomNum = rand * maxWeight;
        System.out.println("randomNum = " + randomNum);
        Weight value = weightedMap.ceilingEntry(randomNum).getValue();
        value.printValue();
        return value;
    }

    private static class Weight<T> {
        Double weight;
        T value;

        public Weight(Double weight, T value) {
            this.weight = weight;
            this.value = value;
        }

        void printValue() {
            System.out.print(value);
        }

        @Override
        public String toString() {
            return "Weight{" +
                    "weight=" + weight +
                    ", value=" + value +
                    '}';
        }
    }
}

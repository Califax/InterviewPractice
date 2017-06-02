package CompanyQuestions;

public class Knapsack {
    // Without Replacement
    static int zeroOneKnapsack(int[] values, int[] weights, int maxWeight) {

        int[][] k = new int[weights.length + 1][maxWeight+1];

        for (int i = 1; i <= weights.length; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                if (w == 0) {
                    k[i][w] = 0;
                } else if (w >= weights[i-1]) {
                    k[i][w] = Math.max(k[i-1][w - weights[i-1]] + values[i-1], k[i-1][w]);
                } else {
                    k[i][w] = k[i-1][w];
                }
            }
        }
        return k[weights.length][maxWeight];
    }

    // With Replacement
    static int unbounded(int[] values, int[] weights, int n) {
        int[] bestValues = new int[n+1];
        for (int w = 1; w <= n; w++) {
            for (int v = 0; v < weights.length; v++) {
                int currWeight = weights[v];
                int currVal = values[v];
                if (w >= currWeight) {
                    bestValues[w] = Math.max(bestValues[w], bestValues[w-currWeight] + currVal);
                }
            }
        }
        return bestValues[n];
    }

    // With Replacement Two, using maxSoFar
    static int unboundedKnapSack(int[] values, int[] weights, int maxWeight) {
        int[] k = new int[maxWeight + 1];
        int maxSoFar = 0;
        for (int w = 0; w <= maxWeight; w++) {
            for (int i = 0; i < weights.length; i++) {
                if (w >= weights[i]) {
                    k[w] = Math.max(k[w - weights[i]] + values[i], maxSoFar);
                }

                if (k[w] > maxSoFar) {
                    maxSoFar = k[w];
                }
            }
        }
        return k[maxWeight];
    }
}

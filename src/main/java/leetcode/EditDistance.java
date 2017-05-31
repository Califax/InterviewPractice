package leetcode;

public class EditDistance {
    public int minDistance(String word1, String word2) {

        int[][] dist = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i <= word1.length(); i++) {
            dist[i][0] = i;
        }

        for (int j = 1; j <= word2.length(); j++) {
            dist[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int subCost = 0;
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    subCost = 1;
                }
                int min = Math.min(dist[i-1][j] + 1, dist[i][j-1] + 1);
                dist[i][j] = Math.min(min, dist[i-1][j-1] + subCost);
            }
        }
//        for (int i = 0; i <= word1.length(); i++) {
//            for (int j = 0; j <= word2.length(); j++) {
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }
        return dist[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        EditDistance obj = new EditDistance();
        String one = "cat";
        String two = "tapx";
        System.out.println(String.format("Expected 3 got %s", obj.minDistance(one, two)));
    }
}

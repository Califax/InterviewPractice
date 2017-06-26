package CompanyQuestions;

public class PrintDiagnols {

    void printDiagnols(int[][] input) {
        int rows = input.length;
        int cols = input[0].length;
        int col = 0;

        for (int row = 0; row < rows; row++) {
            if (col == cols) {
                printDiag(input, row, cols - 1, rows, cols);
            }

            while (col < cols) {
                printDiag(input, row, col, rows, cols);
                col++;
            }
        }
    }

    void printDiag(int[][] input, int row, int col, int rows, int cols) {
        while (row < rows && col >= 0) {
            System.out.print(input[row][col] + " ");
            row++;
            col--;
        }
        System.out.println();
    }

    int[][] genArray(int rows, int cols) {
        int[][] arr = new int[rows][cols];
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                arr[row][col] = count;
                count++;
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }

        return arr;
    }

    public static void main(String[] args) {
        PrintDiagnols obj = new PrintDiagnols();
        int[][] arr = obj.genArray(4, 3);
        obj.printDiagnols(arr);
    }
}

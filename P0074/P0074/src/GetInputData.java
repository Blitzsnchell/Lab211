
import java.util.Scanner;

public class GetInputData {

    static Scanner sc = new Scanner(System.in);
    static Management management = new Management();
    Validation validate = new Validation();

    private int row;
    private int column;

    public int getInputChoice() {
        return validate.checkIntLitmit("Your choice: ", 1, 5);
    }

    public Matrix getInputMatrix1() {
        System.out.printf("Enter Row Matrix 1:");
        row = validate.getIntPositive("Enter Row Matrix 1:");
        System.out.printf("Enter column Matrix 1:");
        column = validate.getIntPositive("Enter Row Matrix 1:");
        return inputMatrix(row, column, 1);

    }

    public Matrix getInputMatrix2(int number, Matrix matrix1) {

        while (true) {
            System.out.print("Enter Row Matrix 2:");
            row = validate.getIntPositive("Enter Row Matrix 2:");
            if (number == 1 && row != matrix1.getRows()) {
                System.out.println("Two matrices must have the same number of rows");
            } else if (number == 2 && row != matrix1.getColumns()) {
                System.out.println("Columns in matrix 1 and rows in matrix 2 must be equal");
            } else {
                break;
            }
        }

        while (true) {
            System.out.printf("Enter Column Matrix 2:");
            column = validate.getIntPositive("Enter Column Matrix 2:");
            if (number == 1 && column != matrix1.getColumns()) {
                System.out.println("Two matrices must have the same number of Columns");
            } else {
                break;
            }
        }
        return inputMatrix(row, column, 2);
    }

    public Matrix inputMatrix(int row, int column, int number) {
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Enter Matrix" + number + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                matrix[i][j] = inputInt(i, j, number);
            }
        }
        return new Matrix(row, column, matrix);
    }

    public int inputInt(int i, int j, int matrix) {
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Value of matrix is digit");
                System.out.print("Enter Matrix" + matrix + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
            }
        }
    }

}

package Controller;

import Model.Matrix;
import java.util.Scanner;

public class Manage {
    private final Scanner scanner = new Scanner(System.in);

    public void add() {
        System.out.println("-------- Addition --------");
        Matrix matrix1 = createMatrix("Matrix 1");
        Matrix matrix2 = createMatrix("Matrix 2");
        Matrix result = Matrix.add(matrix1, matrix2);
        displayResult(matrix1, matrix2, result, "+");
    }

    public void sub() {
        System.out.println("-------- Subtraction --------");
        Matrix matrix1 = createMatrix("Matrix 1");
        Matrix matrix2 = createMatrix("Matrix 2");
        Matrix result = Matrix.subtract(matrix1, matrix2);
        displayResult(matrix1, matrix2, result, "-");
    }

    public void mul() {
        System.out.println("-------- Multiplication --------");
        Matrix matrix1 = createMatrix("Matrix 1");
        Matrix matrix2 = createMatrix("Matrix 2");
        Matrix result = Matrix.multiply(matrix1, matrix2);
        displayResult(matrix1, matrix2, result, "*");
    }

    private Matrix createMatrix(String name) {
        System.out.print("Enter number of rows for " + name + ": ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns for " + name + ": ");
        int columns = scanner.nextInt();
        scanner.nextLine();

        Matrix matrix = new Matrix(rows, columns);
        matrix.inputMatrix(scanner, name);
        return matrix;
    }

    private void displayResult(Matrix m1, Matrix m2, Matrix result, String operation) {
        if (result == null) {
            System.out.println("Can not calculate");
        } else {
            m1.printMatrix();
            System.out.println(operation);
            m2.printMatrix();
            System.out.println("=");
            result.printMatrix();
        }
    }
}

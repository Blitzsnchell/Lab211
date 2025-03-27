/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MatrixController {
    private final Scanner scanner = new Scanner(System.in);

    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        if (!isSameSize(matrix1, matrix2)) {
            return null;
        }

        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        if (!isSameSize(matrix1, matrix2)) {
            return null;
        }

        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1 == null || matrix2 == null || matrix1.length == 0 || matrix2.length == 0
                || matrix1[0].length != matrix2.length) {
            return null;
        }

        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    private boolean isSameSize(int[][] matrix1, int[][] matrix2) {
        return matrix1 != null && matrix2 != null
                && matrix1.length > 0 && matrix2.length > 0
                && matrix1.length == matrix2.length
                && matrix1[0].length == matrix2[0].length;
    }

    public int[][] inputMatrix(String name) {
        int rows, cols;

        while (true) {
            System.out.print("Enter Row " + name + ": ");
            try {
                rows = Integer.parseInt(scanner.nextLine());
                if (rows > 0) {
                    break;
                } else {
                    System.out.println("Row count must be a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }

        while (true) {
            System.out.print("Enter Column " + name + ": ");
            try {
                cols = Integer.parseInt(scanner.nextLine());
                if (cols > 0) {
                    break;
                } else {
                    System.out.println("Column count must be a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter values for " + name + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                while (true) {
                    System.out.print("Matrix[" + (i + 1) + "][" + (j + 1) + "]: ");
                    try {
                        matrix[i][j] = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Value of matrix is digit.");
                    }
                }
            }
        }
        return matrix;
    }

    public void printMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print("[" + element + "]");
            }
            System.out.println();
        }
    }
}

package Model;

import java.util.Scanner;

public class Matrix {
    private int rows;
    private int columns;
    private int[][] data;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new int[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getData() {
        return data;
    }

    public void inputMatrix(Scanner scanner, String name) {
        System.out.println("Enter values for " + name + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                while (true) {
                    System.out.print("Matrix[" + (i + 1) + "][" + (j + 1) + "]: ");
                    try {
                        data[i][j] = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Value must be an integer.");
                    }
                }
            }
        }
    }

    public void printMatrix() {
        for (int[] row : data) {
            for (int element : row) {
                System.out.print("[" + element + "]");
            }
            System.out.println();
        }
    }

    public static Matrix add(Matrix m1, Matrix m2) {
        if (m1.getRows() != m2.getRows() || m1.getColumns() != m2.getColumns()) {
            return null;
        }
        Matrix result = new Matrix(m1.getRows(), m1.getColumns());
        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m1.getColumns(); j++) {
                result.data[i][j] = m1.data[i][j] + m2.data[i][j];
            }
        }
        return result;
    }

    public static Matrix subtract(Matrix m1, Matrix m2) {
        if (m1.getRows() != m2.getRows() || m1.getColumns() != m2.getColumns()) {
            return null;
        }
        Matrix result = new Matrix(m1.getRows(), m1.getColumns());
        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m1.getColumns(); j++) {
                result.data[i][j] = m1.data[i][j] - m2.data[i][j];
            }
        }
        return result;
    }

    public static Matrix multiply(Matrix m1, Matrix m2) {
        if (m1.getColumns() != m2.getRows()) {
            return null;
        }
        Matrix result = new Matrix(m1.getRows(), m2.getColumns());
        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m2.getColumns(); j++) {
                for (int k = 0; k < m1.getColumns(); k++) {
                    result.data[i][j] += m1.data[i][k] * m2.data[k][j];
                }
            }
        }
        return result;
    }
}
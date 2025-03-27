/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Admin
 */
public class Manage {

    MatrixController mc = new MatrixController();
    static int[][] result, matrix1, matrix2;

    public void add() {
        System.out.println("-------- Addition --------");

        matrix1 = mc.inputMatrix("Matrix 1");
        matrix2 = mc.inputMatrix("Matrix 2");

        result = mc.additionMatrix(matrix1, matrix2);

        System.out.println("-------- Result --------");
        if (result == null) {
            System.out.println("Can not calculate");
        } else {
            mc.printMatrix(matrix1);
            System.out.println("+");
            mc.printMatrix(matrix2);
            System.out.println("=");
            mc.printMatrix(result);
        }
    }

    public void sub() {
        System.out.println("-------- Subtraction --------");

        matrix1 = mc.inputMatrix("Matrix 1");
        matrix2 = mc.inputMatrix("Matrix 2");

        result = mc.subtractionMatrix(matrix1, matrix2);

        System.out.println("-------- Result --------");
        if (result == null) {
            System.out.println("Can not calculate");
        } else {
            mc.printMatrix(matrix1);
            System.out.println("-");
            mc.printMatrix(matrix2);
            System.out.println("=");
            mc.printMatrix(result);
        }

    }

    public void mul() {
        System.out.println("-------- Multiplication --------");

        matrix1 = mc.inputMatrix("Matrix 1");
        matrix2 = mc.inputMatrix("Matrix 2");

        result = mc.multiplicationMatrix(matrix1, matrix2);

        System.out.println("-------- Result --------");
        if (result == null) {
            System.out.println("Can not calculate");
        } else {
            mc.printMatrix(matrix1);
            System.out.println("*");
            mc.printMatrix(matrix2);
            System.out.println("=");
            mc.printMatrix(result);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Main {
    
    public static void execute() {
        Matrix matrix = new Matrix();
        int choice;
        
        int row1, row2, col1, col2;
        int[] size1, size2;
        int[][] matrix1, matrix2, res;
        
        do {
            System.out.println("====== CALCULATOR PROGRAM ======");
            choice = Menu.getChoice(Menu.MENU);
            
            if (choice == 4) break;
            
            size1 = matrix.inputSize("Matrix 1");
            size2 = matrix.inputSize("Matrix 2");

            row1 = size1[0];
            col1 = size1[1];
            row2 = size2[0];
            col2 = size2[1];
            
            switch (choice) {
                case 1:
                    if (Validation.checkAddSubtractCondition(row1, col1, row2, col2)) {
                        matrix1 = new int[row1][col1];
                        matrix2 = new int[row2][col2];
                        
                        matrix.input(matrix1, "Matrix 1");
                        matrix.input(matrix2, "Matrix 2");
                        
                        res = matrix.additionMatrix(matrix1, matrix2);
                        
                        System.out.println("------ RESULT ------");
                        matrix.output(matrix1);
                        System.out.println("+");
                        matrix.output(matrix2);
                        System.out.println("=");
                        matrix.output(res);
                    } else {
                        System.err.println("Wrong size for addition, 2 matrixes must have same size of row and column");
                    }
                    break;
                case 2:
                    if (Validation.checkAddSubtractCondition(row1, col1, row2, col2)) {
                        matrix1 = new int[row1][col1];
                        matrix2 = new int[row2][col2];
                        
                        matrix.input(matrix1, "Matrix 1");
                        matrix.input(matrix2, "Matrix 2");
                        
                        res = matrix.subtractionMatrix(matrix1, matrix2);
                        
                        System.out.println("------ RESULT ------");
                        matrix.output(matrix1);
                        System.out.println("-");
                        matrix.output(matrix2);
                        System.out.println("=");
                        matrix.output(res);
                    } else {
                        System.err.println("Wrong size for subtraction, 2 matrixes must have same size of row and column");
                    }
                    break;
                case 3:
                    if (Validation.checkMultiplyCondition(row1, col1, row2, col2)) {
                        matrix1 = new int[row1][col1];
                        matrix2 = new int[row2][col2];
                        
                        matrix.input(matrix1, "Matrix 1");
                        matrix.input(matrix2, "Matrix 2");
                        
                        res = matrix.multiplicationMatrix(matrix1, matrix2);
                        
                        System.out.println("------ RESULT ------");
                        matrix.output(matrix1);
                        System.out.println("*");
                        matrix.output(matrix2);
                        System.out.println("=");
                        matrix.output(res);
                    } else {
                        System.err.println("Wrong size for multiplication, column of first matrix must equal to row of second matrix");
                    }
                    break;
                case 4:
                    break;
            }
            
            System.out.println();
        } while (choice != Menu.MENU.length);
    }
    
    public static void main(String[] args) {
        execute();
    }
    
}

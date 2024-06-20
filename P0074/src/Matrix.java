/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Matrix {
    
    public int[] inputSize(String name) {
        int row = Validation.getInt("Enter Row " + name + ": ", 1, Integer.MAX_VALUE);
        int col = Validation.getInt("Enter Column " + name + ": ", 1, Integer.MAX_VALUE); 
        return new int[] {row, col};
    }
    
    public void input(int[][] matrix, String name) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Validation.getInt("Enter " + name + "[" 
                        + (i + 1) + "][" + (j + 1) + "]: ", -Integer.MAX_VALUE, Integer.MAX_VALUE);
            }
        }
    }
    
    public void output(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
    
    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] res = new int[matrix1.length][matrix1[0].length];
        
        int row = matrix1.length;
        int col = matrix1[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        
        return res;
    }
    
    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] res = new int[matrix1.length][matrix1[0].length];
        
        int row = matrix1.length;
        int col = matrix1[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        
        return res;
    }
    
    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] res = new int[matrix1.length][matrix2[0].length];
        
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    res[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        return res;
    }
    
}

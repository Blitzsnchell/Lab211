
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tuan
 */
public class Test {

    public static void testAdd() {
        Matrix matrix1 = new Matrix();
        matrix1.setColumns(2);
        matrix1.setRows(2);
        int ma1[][] = {
            {1, 2},
            {2, 3}
        };
        matrix1.setMatrix(ma1);
        Matrix matrix2 = new Matrix();
        matrix2.setColumns(2);
        matrix2.setRows(2);
        int ma2[][] = {
            {1, 2},
            {2, 3}
        };
        matrix2.setMatrix(ma1);

        System.out.println("---------Addition------");
        int[][] resultMatrix = new int[matrix1.getRows()][matrix1.getColumns()];
        for (int i = 0; i < matrix1.getRows(); i++) {
            for (int j = 0; j < matrix1.getColumns(); j++) {
                resultMatrix[i][j] = matrix1.getMatrix()[i][j] + matrix2.getMatrix()[i][j];
            }
        }
        System.out.println("----------Result----------");
        displayMatrix(matrix1.getMatrix(), matrix1.getRows(), matrix1.getColumns());
        System.out.println("+");
        displayMatrix(matrix2.getMatrix(), matrix2.getRows(), matrix2.getColumns());
        System.out.println("=");
        displayMatrix(resultMatrix, matrix1.getRows(), matrix1.getColumns());
    }

    static void displayMatrix(int matrix[][], int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        testAdd();
    }
}

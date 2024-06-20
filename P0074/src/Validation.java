
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Validation {
    
    public static Scanner sc = new Scanner(System.in);
    
    public static int getInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (min <= n && n <= max) return n;
                System.err.println("Out of range, your number must from: " + min + " to " + max);
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format, please input an integer");
            }
        }
    }
    
    public static boolean checkAddSubtractCondition(int row1, int col1, int row2, int col2) {
        return row1 == row2 && col1 == col2;
    }
    
    public static boolean checkMultiplyCondition(int row1, int col1, int row2, int col2) {
        return col1 == row2;
    }
    
}

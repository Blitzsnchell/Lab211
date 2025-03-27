/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import utils.Validate;

/**
 *
 * @author Admin
 */
public class ViewCalculateMatrix {

    public static int menu() {
        System.out.println("======= Calculator program =======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        int choice = Validate.checkInputIntLimit("Your choice: ", 1, 4);
        return choice;
    }
}

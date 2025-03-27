/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

public class Validate {

    private final static Scanner in = new Scanner(System.in);

    //check user input number limit
    public static int checkInputIntLimit(String message, int min, int max) {
        //loop until user input correct
        while (true) {
            System.out.print(message);
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input integer in rage [" + min + ", " + max + "].");
            }
        }
    }

    //check user input int
    public static int checkInputInt(String message) {
        //loop until user input correct
        while (true) {
            System.out.print(message);
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input an integer !!");
            }
        }
    }
}

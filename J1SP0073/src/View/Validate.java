/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.Scanner;

/**
 *
 * @author Fpt
 */
public class Validate {
    
    private static final Scanner in = new Scanner(System.in);
    private static final String DATE_VALID = "^(0[1-9]|[12][0-9]|3[01])-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{4}$";
    
    public static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

     public static String checkInputDate() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.matches(DATE_VALID)) {
                return result;
            } else {
                System.err.println("Invalid format! Please enter again (dd-MMM-yyyy), e.g., 05-Jun-2024");
            }
        }
    }

    public static double checkInputDouble() {
        while (true) {
            try {
                return Double.parseDouble(in.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            }
            System.err.println("Re-input");
        }
    }

    public static int checkInputInt() {
        while (true) {
            try {
                return Integer.parseInt(in.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }
}

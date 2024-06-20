package controller;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {

    static Scanner sc = new Scanner(System.in);
    
    public static int getInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int n = Integer.parseInt(sc.nextLine());
                if (min <= n && n <= max) {
                    return n;
                }
                System.err.println("Must from: " + min + " to " + max);
            } catch (NumberFormatException ex) {
                System.err.println("Wrong format");
            }
        }
    }

    public static String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            if (!s.isEmpty()) {
                return s;
            }
            System.err.println("Empty string is not allowed");
        }
    }

    public static boolean getInputYN(String msg) {
        while (true) {
            String s = getString(msg);
            if (s.equalsIgnoreCase("Y")) {
                return true;
            }
            if (s.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input Y or N");
        }
    }
    
    public static boolean getInputUD(String msg) {
        while (true) {
            String s = getString(msg);
            if (s.equalsIgnoreCase("U")) {
                return true;
            }
            if (s.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input U or D");
        }
    }

    public static String getInputCourse(String msg) {
        while (true) {
            String s = getString(msg);
            if (s.equalsIgnoreCase("java") 
                    || s.equalsIgnoreCase(".net") 
                    || s.equalsIgnoreCase("c/c++")) {
                return s;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
        }
    }
    
}

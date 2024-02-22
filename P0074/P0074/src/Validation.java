
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tuan
 */
public class Validation {

    static Scanner sc = new Scanner(System.in);

    public String checkEmpty(String mess) {
        while (true) {
            System.out.println(mess);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Empty! Please input again ");
            } else {
                return input;
            }
        }
    }

    public int checkIntLitmit(String mess, int min, int max) {
        while (true) {
            try {
                String input = checkEmpty(mess);
                int inp = Integer.parseInt(input);
                if (inp >= min && inp <= max) {
                    return inp;
                } else {
                    System.out.println("Input in range: " + min + "to" + max);
                }

            } catch (NumberFormatException e) {
                System.out.println("Invaild choice,please input again");
            }
        }
    }

    public int getIntPositive(String mess) {
        while (true) {
            try {
                String input = checkEmpty(mess);
                int number = Integer.parseInt(input);
                if (number <= 0) {
                    System.out.println("Please enter a positive integer ");
                    System.out.print(mess);
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a positive integer ");
                System.out.print(mess);
            }
        }
    }
}

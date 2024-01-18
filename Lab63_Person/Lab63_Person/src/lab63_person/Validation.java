/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab63_person;

import java.util.Scanner;

public class Validation {

    Scanner sc = new Scanner(System.in);

    public String checkEmpty(String mess) {
        while (true) {
            System.out.print(mess);
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.err.println("Not empty!");
            } else {
                return input;
            }
        }
    }

    public int checkInt(String mess, String messError) {
        while (true) {
            try {
                int input = Integer.parseInt(checkEmpty(mess));
                return input;
            } catch (Exception e) {
                System.err.println(messError);
            }
        }
    }

    public double checkSalary(String mess, String messError) {
        while (true) {
            try {
                Double input = Double.parseDouble(checkEmpty(mess));
                if (input > 0) {
                    return input;
                } else {
                    System.out.print(mess);
                    System.out.println(messError);
                }
            } catch (Exception e) {
                System.err.println("Must be a number!");
            }
        }
    }

    public static void main(String[] args) {
        Validation input = new Validation();
        System.out.println(input.checkSalary("Enter Salary: ", "Must be a possitive number!"));
    }
}

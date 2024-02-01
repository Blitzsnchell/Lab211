/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bubblesort2ways;

import java.util.Scanner;

public class Validation {

    Scanner sc = new Scanner(System.in);

    public String checkEmpty(String mess) {
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.err.println("Not empty!");
            } else {
                return input;
            }
        }
    }

    public int checkPositiveNumber(String mess, String messError) {
        while (true) {
            try {
                int input = Integer.parseInt(checkEmpty(mess));
                if (input > 0) {
                    return input;
                } else {
                    System.err.println("Input must be positive!");
                }
            } catch (Exception e) {
                System.err.println(messError);
            }
        }
    }

    public int checkIntLimit(String mess, String messError, int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(checkEmpty(mess));
                if(input >=min && input <=max){
                    return input;
                } else {
                    System.err.println("Input must be in range: " + min +"-"+ max);
                }
            } catch (Exception e) {
                System.err.println(messError);

            }
        }
    }

    public static void main(String[] args) {
        Validation input = new Validation();
        System.out.println(input.checkPositiveNumber("Enter number of array:", "Must be integer"));
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarysearchlab211;

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
    
    public static void main(String[] args) {
        Validation input = new Validation();
        System.out.println(input.checkInt("Enter number of array:", "Must be integer"));
    }
}

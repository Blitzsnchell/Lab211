package com.mycompany.j1.l.p0023;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hoang
 */
public class Validation {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static String inputString(String message){
        String input = "";
        while(true){
            try{
                System.out.println(message);
                input = scanner.nextLine();
                if(input.isEmpty()){
                    System.out.println("input not recor");
                    continue;
                }
                break;
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return input;
    }
    
    public static int inputInt(String message){
        int input = 0;
        String string = "";
        while(true){
            try{
                string = inputString(message);
                input = Integer.parseInt(string);
                break;
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return input;
    }
    
    public static double inputDouble(String message){
        double input = 0;
        String string = "";
        while(true){
            try{
                string = inputString(message);
                input = Double.parseDouble(string);
                break;
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return input;
    }
    
    public static boolean inputYesNo(String message){
        String input = "";
        while(true){
            try{
                System.out.println(message);
                input = scanner.nextLine();
                if(input.isEmpty()){
                    System.out.println("input not recor");
                    continue;
                }
                break;
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        if(input.equalsIgnoreCase("Y")){
            return true;
        }else{
            return false;
        }
    }
}

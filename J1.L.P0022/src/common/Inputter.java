/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import model.Candidate;

/**
 *
 * @author Admin
 */
public class Inputter {

    public Scanner sc = new Scanner(System.in);
    
    private static final String PHONE_VALID = "^\\d{10}\\d*$";
    private static final String EMAIL_VALID = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";

    public int getInt(String msg, int min, int max) {
        int n;
        while (true) {
            System.out.print(msg);
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n >= min && n <= max) {
                    break;
                }
                System.err.println("Must from " + min + " to " + max);
            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer");
            }
        }
        
        return n;
    }

    public String getString(String msg) {
        String s;
        while (true) {
            System.out.print(msg);
            try {
                s = sc.nextLine();
                if (!s.isEmpty()) {
                    break;
                }
            } catch (Exception e) {
                System.err.println("Enter again");
            }
        }
        
        return s;
    }

    public boolean getYN() {
        while (true) {
            String res = getString("Do you want to continue (Y/N)? ");
            if (res.equalsIgnoreCase("Y")) {
                return true;
            } 
            
            if (res.equalsIgnoreCase("N")) {
                return false;
            }
            
            System.err.println("Please enter Y/y or N/n only");
        }
    }

    public String getPhone() {
        while (true) {
            String res = getString("Enter phone number: ");
            if (res.matches(PHONE_VALID)) {
                return res;
            }
            
            System.err.println("Phone is a string with minimum 10 digits");            
        }
    }

    public String getEmail() {
        while (true) {
            String res = getString("Enter email: ");
            if (res.matches(EMAIL_VALID)) {
                return res;
            } 
            
            System.err.println("Email must have format <account name>@<domain>");            
        }
    }

    public String getGraduationRank() {
        while (true) {
            String res = getString("");
            if (res.equalsIgnoreCase("Excellence")
                    || res.equalsIgnoreCase("Good")
                    || res.equalsIgnoreCase("Fair")
                    || res.equalsIgnoreCase("Poor")) {
                return res;
            } 
            
            System.err.println("Please enter 1 of 4 strings: Excellence, Good, Fair, Poor");            
        }
    }

    public boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Candidate ID is exist.");
                return true;
            }
        }
        
        return false;
    }

    public int gettExprience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = getInt("", 1, 100);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }

    }

    public void displayNotice(String n) {
        System.out.println(n);
    }

    public void displayErr(String e) {
        System.err.println(e);
    }
}

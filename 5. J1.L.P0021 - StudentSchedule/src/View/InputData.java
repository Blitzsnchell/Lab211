package View;


import java.util.Scanner;


public class InputData {
    private static Scanner sc = new Scanner(System.in);
    
    public static int inputInteger(String mess, int min, int max) {
        int num = 0;
        System.out.println(mess);
        // loop until user input true format
        while (true) {            
            try{
                num = Integer.parseInt(sc.nextLine().trim());
                if(num < min || num > max)  throw new NumberFormatException();
                break;
            }catch(NumberFormatException ex){
                System.out.println("Please enter an integer in range " + min + " -> " + max);
                System.out.print("Enter again: ");
            }   
        }
        return num;
    }

    public static String inputString(String mess) {
        String string;
        System.out.println(mess);
        // loop until user input true format
        while (true) {            
            string = sc.nextLine().trim();
            if(string.isEmpty()){
                System.out.println("Please don't input a null string.");
                System.out.print("Enter again: ");
            }else   break;
        }
        return string;
    }

    public static float inputFloat(String mess, int min) {
        float num;
        System.out.println(mess);
        // loop until user input true format
        while (true) {            
            try{
                num = Float.parseFloat(sc.nextLine().trim());
                if(num <= min)  throw new NumberFormatException();
                break;
            }catch(NumberFormatException ex){
                System.out.println("Please enter a real number that it must be greater than " + min);
            }   System.out.print("Enter again: ");
        }
        return num;
    }

    public static String inputCourseName(String mess) {
        String string;
        System.out.println(mess);
        // loop until user input true format
        while (true) {            
            string = sc.nextLine().trim();
            // check string empty
            if(string.isEmpty()){
                System.out.println("Please don't input a null string.");
                System.out.print("Enter again: ");
            }
            // check name course
            else if(string.equalsIgnoreCase("Java") 
                    || string.equalsIgnoreCase(".Net")
                    || string.equalsIgnoreCase("C/C++"))    break;
            else{
                System.out.println("There are only three courses: Java, .Net, C/C++ ");
                System.out.println("Enter again: ");
            }
        }
        return string;
    }

    public static boolean inputYN(String mess, String s1, String s2) {
        String string;
        System.out.println(mess);
        // loop until user input true format
        while (true) {            
            string = sc.nextLine().trim();
            if(string.isEmpty()){
                System.out.println("Please, don't input a null string.");
                System.out.println("Enter again: ");
            }else if(string.equalsIgnoreCase(s1))               return true;
            else if(string.equalsIgnoreCase(s2))                return false;
            else{
                System.out.println("Please input a character " + s1 + " or " + s2);
                System.out.print("Enter again: ");
            }
        }
    }
        

}

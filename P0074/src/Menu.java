/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Menu {
    
    public static String[] MENU = {
        "Addition Matrix",
        "Subtraction Matrix",
        "Multiplication Matrix",
        "Quit"
    };
    
    public static int getChoice(String[] menu) {
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }
        
        return Validation.getInt("Your choice: ", 1, menu.length);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Admin
 */
public class View {
    
    private String[] menu = {
        "Vietnamese",
        "English",
        "Exit"
    };
    
    public void menu() {
        System.out.println("====== Login Program ======");
        for (int i = 0; i < menu.length; i++)
            System.out.println((i+1) + ". " + menu[i]);
    }
    
}
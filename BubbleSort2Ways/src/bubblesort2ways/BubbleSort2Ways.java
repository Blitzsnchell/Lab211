/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort2ways;

/**
 *
 * @author tuan
 */
public class BubbleSort2Ways {

//        System.out.println("1.   Input items of the array");
//        System.out.println("2.   Sort the array in ascending order");
//        System.out.println("3.   Sort the array in descending order");
//        System.out.println("4.   Exit");
    public static void main(String[] args) {

//        //Step 1: Display a menu and ask a user to select an option.
        Menu menu = new Menu();
        menu.menuDisplay();
        menu.menuProcess();

    }

}

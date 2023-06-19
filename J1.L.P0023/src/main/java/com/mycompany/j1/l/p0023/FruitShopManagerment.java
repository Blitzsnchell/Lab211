/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j1.l.p0023;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class FruitShopManagerment {

    private Scanner scanner = new Scanner(System.in);
    private FruitStore fruitStore = new FruitStore();
    private Order orders = new Order();

    public void menu() {
        System.out.println("Menu:");
        System.out.println("1.Create Fruit");
        System.out.println("2.View orders");
        System.out.println("3.Shopping");
        System.out.println("4.Exit");
    }

    public void makeChoice() {
        int choice = 0;
        while (choice != 4) {
            menu();
            choice = Validation.inputInt("Enter your choice:");

            switch (choice) {
                case 1 -> {
                    addFruitToStore();
                }
                case 2 -> {
                    orders.printAllCustomerShoppingList();
                }
                case 3 ->
                    addFruitToOrder();
                case 4 ->
                    System.out.println("Exiting...");
                default ->
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void addFruitToStore() {
        fruitStore.addFruit();
    }

    public void addFruitToOrder() {
        ArrayList<Fruit> list = new ArrayList<Fruit>();
        int fruitId;
        while (true) {
            fruitStore.viewFruitList();
            fruitId = Validation.inputInt("Select fruit you want to buy");
            Fruit f = fruitStore.findFruitById(fruitId);
            if (f != null) {
                System.out.println("Your Selected: " + f.getName());
                orders.addFruitToCustomer(list,f);
            }else{
                continue;
            }
            boolean isContinue = Validation.inputYesNo("Do you want to continue (Y/N)? ");
            if(!isContinue){
                break;
            }
        }
        orders.printShoppingList(list);
        String customerName = Validation.inputString("Enter customer name:");
        orders.createShopping(customerName,list);
    }
}

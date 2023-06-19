/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j1.l.p0023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hoang
 */
public class Order {

    private Map<String, ArrayList<Fruit>> dictionary = new HashMap<String, ArrayList<Fruit>>();

    public void createShopping(String customerName, ArrayList<Fruit> list) {
        dictionary.put(customerName, list);
    }

    public void addFruitToCustomer(ArrayList<Fruit> list, Fruit fruit) {
        int quantity = 0;
        while (true) {
            quantity = Validation.inputInt("Enter quantity you want to buyt: ");
            if (quantity > fruit.getQuantity()) {
                System.out.println("Quantity in store not enought");
            } else if (quantity <= 0) {
                System.out.println("Invalid input");
            } else {
                break;
            }
        }
        fruit.setQuantity(fruit.getQuantity() - quantity);
        for(Fruit item : list){
            if(item.getName().equalsIgnoreCase(fruit.getName())){
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        list.add(new Fruit(fruit.getName(), fruit.getPrice(), quantity, fruit.getOrigin()));
    }

    public void printShoppingList(ArrayList<Fruit> shoppingList){
        System.out.println("Product | Quantity | Price | Amount");

        double totalAmount = 0;

        for (int i = 0; i < shoppingList.size(); i++) {
            Fruit fruit = shoppingList.get(i);
            double amount = fruit.getPrice() * fruit.getQuantity();
            totalAmount += amount;

            System.out.printf("%d. %-12s %d \t %.2f$ \t %.2f$\n",
                    i + 1,
                    fruit.getName(),
                    fruit.getQuantity(),
                    fruit.getPrice(),
                    amount);
        }

        System.out.println("Total: " + totalAmount + "$");
    }
    
    public void printCustomerShoppingList(String customerName) {
        ArrayList<Fruit> shoppingList = dictionary.get(customerName);

        if (shoppingList == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println("Customer: " + customerName);
        printShoppingList(shoppingList);
    }
    
    public void printAllCustomerShoppingList(){
        for(String name : dictionary.keySet()){
            printCustomerShoppingList(name);
        }
    }

}

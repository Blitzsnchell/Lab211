/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j1.l.p0023;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoang
 */
public class FruitStore {

    private final List<Fruit> fruitList;

    public FruitStore() {
        fruitList = new ArrayList<Fruit>();
        fruitList.add(new Fruit("tao", 150, 15, "HN"));
        fruitList.add(new Fruit("cam", 100, 5, "HN"));
        fruitList.add(new Fruit("oi", 50, 15, "SG"));
    }

    public void addFruit() {
        String name = Validation.inputString("Enter the fruit name:");
        Double price = Validation.inputDouble("Enter the fruit price:");
        int quantity = Validation.inputInt("Enter the fruit quantity:");
        String origin = Validation.inputString("Enter the fruit origin:");
        Fruit fruit = new Fruit(name, price, quantity, origin);
        fruitList.add(fruit);
        System.out.println("Fruit added successfully.");
    }

    public void viewFruitList() {
        if (fruitList.isEmpty()) {
            System.out.println("No fruits available.");
        } else {
            System.out.println("Fruit List:");
            // Display the header
            System.out.printf("| %8s | %15s | %14s | %10s | %7s |\n", "++ Item ++", "++ Fruit Name ++", "++ Quantity ++ ", "++ Origin ++", "++ Price ++");

            // Display the fruits
            for (int i = 0; i < fruitList.size(); i++) {
                System.out.printf("| %10d | %17s | %16d | %12s | %9s |\n", fruitList.get(i).getId(), fruitList.get(i).getName(), fruitList.get(i).getQuantity(), fruitList.get(i).getOrigin(), fruitList.get(i).getPrice());
            }
        }
    }

    public Fruit findFruitById(int id) {
        for (Fruit fruit : fruitList) {
            if (fruit.getId() == id) {
                return fruit;
            }
        }
        return null;
    }
}

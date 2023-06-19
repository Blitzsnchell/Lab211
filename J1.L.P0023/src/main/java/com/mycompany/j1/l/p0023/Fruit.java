/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.j1.l.p0023;

/**
 *
 * @author hoang
 */
class Fruit {

    private static int idCount = 1;
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String origin;

    public Fruit(String name, double price, int quantity, String origin) {
        this.id = idCount;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
        idCount += 1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public static int getIdCount() {
        return idCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

}

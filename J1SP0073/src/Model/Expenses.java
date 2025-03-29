package Model;

import java.util.HashSet;
import java.util.Scanner;

public class Expenses {
    private int id;
    private String date;
    private double amount;
    private String content;
    private static HashSet<String> existingExpenses = new HashSet<>(); // Lưu trữ để kiểm tra trùng
    
    public Expenses(int id, String date, double amount, String content) {
        Scanner scanner = new Scanner(System.in);
        String expenseKey = date + "-" + amount + "-" + content;
        
        if (existingExpenses.contains(expenseKey)) {
            System.out.println("This expense already exists. Do you want to add it again? (Y/N): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("y")) {
                System.out.println("Expense not added.");
                return;
            }
        }
        
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.content = content;
        existingExpenses.add(expenseKey);
//        System.out.println("Expense added successfully!");
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import Model.Expenses;
import View.Validate;
import View.View;

/**
 *
 * @author Fpt
 */
public class ExpensesController {
    

    public static void handleAddExpense() {
        System.out.print("Enter Date (dd-MMM-yyyy): ");
        String date = Validate.checkInputDate();
        System.out.print("Enter Amount: ");
        double amount = Validate.checkInputDouble();
        System.out.print("Enter Content: ");
        String content = Validate.checkInputString();

        Expenses expense = ExpensesManager.createExpense(date, amount, content);
        ExpensesManager.addExpense(expense);
        System.out.println("Expense added successfully!");
    }

    public static  void displayExpenses() {
        if (ExpensesManager.getExpensesList().isEmpty()) {
            System.err.println("No expenses recorded.");
            return;
        }

        System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount", "Content");
        for (Expenses expense : ExpensesManager.getExpensesList()) {
            System.out.printf("%-7d%-20s%-20.0f%-20s\n",
                    expense.getId(), expense.getDate(), expense.getAmount(), expense.getContent());
        }
        System.out.printf("Total: %-20.0f\n", ExpensesManager.getTotalExpenses());
    }

    public static  void handleDeleteExpense() {
        System.out.print("Enter ID to delete: ");
        int id = Validate.checkInputInt();

        if (ExpensesManager.deleteExpense(id)) {
            System.out.println("Expense deleted successfully!");
        } else {
            System.err.println("Expense not found!");
        }
    }
}

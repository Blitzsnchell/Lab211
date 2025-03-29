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
    private ExpensesManager em = new ExpensesManager();
    private Validate val = new Validate();
    public void handleAddExpense() {
        System.out.print("Enter Date (dd-MMM-yyyy): ");
        String date = val.checkInputDate();
        System.out.print("Enter Amount: ");
        double amount = val.checkInputDouble();
        System.out.print("Enter Content: ");
        String content = val.checkInputString();

        Expenses expense = em.createExpense(date, amount, content);
        em.addExpense(expense);
        System.out.println("Expense added successfully!");
    }

    public void displayExpenses() {
        if (em.getExpensesList().isEmpty()) {
            System.err.println("No expenses recorded.");
            return;
        }

        System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount", "Content");
        for (Expenses expense : em.getExpensesList()) {
            System.out.printf("%-7d%-20s%-20.0f%-20s\n",
                    expense.getId(), expense.getDate(), expense.getAmount(), expense.getContent());
        }
        System.out.printf("Total: %-20.0f\n", em.getTotalExpenses());
    }

    public void handleDeleteExpense() {
        System.out.print("Enter ID to delete: ");
        int id = val.checkInputInt();

        if (em.deleteExpense(id)) {
            System.out.println("Expense deleted successfully!");
        } else {
            System.err.println("Expense not found!");
        }
    }
}

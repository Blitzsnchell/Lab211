package Manager;

import Model.Expenses;
import View.Validate;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Fpt
 */
public class ExpensesManager {

    public static ArrayList<Expenses> expensesList = new ArrayList<>();
    public static int idCounter = 0;

    public static Expenses createExpense(String date, double amount, String content) {
        return new Expenses(++idCounter, date, amount, content);
    }

    public static void addExpense(Expenses expense) {
        expensesList.add(expense);
    }

    public static ArrayList<Expenses> getExpensesList() {
        return expensesList;
    }

    public static double getTotalExpenses() {
        double total = 0;
        for (Expenses expense : expensesList) {
            total += expense.getAmount();
        }
        return total;
    }

    public static boolean deleteExpense(int id) {
        int index = findExpenseById(id);
        if (index != -1) {
            expensesList.remove(index);
            // Cập nhật ID sau khi xóa
            for (int i = id - 1; i < expensesList.size(); i++) {
                expensesList.get(i).setId(expensesList.get(i).getId() - 1);
            }
            idCounter--;
            return true;
        }
        return false;
    }

    public static int findExpenseById(int id) {
        for (int i = 0; i < expensesList.size(); i++) {
            if (expensesList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}

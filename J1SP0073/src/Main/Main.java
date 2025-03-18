/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Manager.ExpensesController;
import Manager.ExpensesManager;
import Model.Expenses;
import View.Validate;
import View.View;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fpt
 */
public class Main {

    public static void main(String[] args) {
        ExpensesManager manager = new ExpensesManager();
        while (true) {
            View.menu();

            int choice = Validate.checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    ExpensesController.handleAddExpense();
                    break;
                case 2:
                    ExpensesController.displayExpenses();
                    break;
                case 3:
                    ExpensesController.handleDeleteExpense();
                    break;
                case 4:
                    return;
            }
        }
    }
}

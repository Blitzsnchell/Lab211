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
        ExpensesController ec = new ExpensesController();
        Validate val = new Validate();
        while (true) {
            View.menu();

            int choice = val.checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    ec.handleAddExpense();
                    break;
                case 2:
                    ec.displayExpenses();
                    break;
                case 3:
                    ec.handleDeleteExpense();
                    break;
                case 4:
                    return;
            }
        }
    }
}

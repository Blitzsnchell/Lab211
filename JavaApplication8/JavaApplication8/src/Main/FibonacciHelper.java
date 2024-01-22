/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author tungl
 */
public class FibonacciHelper {

  public int findFibonacci(int[] storeFibonacci, int terms) {
        //base cases of Fibonacci
        if(terms <= 1) {
            storeFibonacci[terms] = terms;
            return storeFibonacci[terms];
        }
        //if terms value is not 0 than return value at certain term
        if(storeFibonacci[terms] != 0) {
            return storeFibonacci[terms];
        }
        //value of next Fibonacci number is sum of 2 preceding Fibonacci number
        storeFibonacci[terms] = findFibonacci(storeFibonacci, terms - 1)
                + findFibonacci(storeFibonacci, terms - 2);
        return storeFibonacci[terms];
    }

    public void displaySequence(int[] storeFibonacci, int terms) {
        for (int i = 0; i <= terms; i++) {
            System.out.print(storeFibonacci[i]);
            System.out.print("Number " + (i+1) + "\t");
            System.out.print(storeFibonacci[i] + "\n");
            if(i < terms) {
                System.out.print(", ");
            }
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bubblesort2ways;

import java.util.Random;

/**
 *
 * @author tungl
 */
public class ArrayInteraction {

    Validation val = new Validation();

    public int[] getArrRamdom(int numberOfArray) {
        int arr[] = new int[numberOfArray];
        for (int i = 0; i < numberOfArray; i++) {
            arr[i] = new Random().nextInt(numberOfArray);
        }
        return arr;
    }

    // Bubble sort
    public void sortyAscending(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array Empty!");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.print("Sorted array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    //sortyAscendingTest
    public void sortArrayDescending(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array Empty!");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.print("Sorted array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void displayArray(int[] arr) {
        System.out.print("Sorted array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int[] intputArrray(int n) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = val.checkPositiveNumber("Enter Number" + (i + 1) + ": ", "Please input number and number is greater than zero");
        }
        return arr;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarysearchlab211;

import java.util.Random;

/**
 *
 * @author tungl
 */
public class ArrayInteraction {

    public int[] getArrRamdom(int numberOfArray) {
        int arr[] = new int[numberOfArray];
        for (int i = 0; i < numberOfArray; i++) {
            arr[i] = new Random().nextInt(numberOfArray);
        }
        return arr;
    }

    // Bubble sort
    public int[] sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    
    
    
    public void displayArray(int[] arr){
        System.out.print("Sorted array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i != arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        ArrayInteraction arr = new ArrayInteraction();
        int array[] = arr.getArrRamdom(10);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("------------------");
        array = arr.sortArray(array);
        arr.displayArray(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}

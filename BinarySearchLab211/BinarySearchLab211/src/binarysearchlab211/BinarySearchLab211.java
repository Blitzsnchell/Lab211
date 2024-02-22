/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package binarysearchlab211;

/**
 *
 * @author tungl
 */
public class BinarySearchLab211 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validation input = new Validation();
        ArrayInteraction a = new ArrayInteraction();
        
        //step 1 enter a positive decimal as size of array
        int numberOfArray = input.checkInt("Enter number of array:", "Must be integer!");
        //step 2 generate random number in array
        int[] arr = a.getArrRamdom(numberOfArray);
        // in ra chua sort
        // sort array (Bubble sortt)
        //step 3  Enter value to search
        int n = input.checkInt("Enter search value:", "Must be integer!");
        // Step 4 using bubble sort to sort array
        arr = a.sortArray(arr);
        //Step 5 display sorted array
        a.displayArray(arr);
        // step 6: display result
        displayResult(arr, n);
        
    }
    public static void displayResult(int arr[], int n){
        BinarySearch search = new BinarySearch();
        int rls = search.binarySearch(arr, n);
        if (rls == -1) {
            System.err.println("Not Found!");
        } else {
            System.out.println("Found " + n + " index: " + rls);
        }
    }

}
